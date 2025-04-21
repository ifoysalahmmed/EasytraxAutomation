package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestDashboardPage extends DriverSetup {

    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private WebDriver driver = getWebDriverThreadLocal();

    @Test(dataProvider = "validLoginData", dataProviderClass = utilities.DataSet.class)
    public void test_dashboard_page(String email, String password) throws InterruptedException {
        loginPage.navigateToLoginPage();
        loginPage.writeOnElement(loginPage.login_email, email);
        loginPage.writeOnElement(loginPage.login_password, password);
        loginPage.clickOnElement(loginPage.login_button);
        Thread.sleep(3000);

        int total_devices = Integer.parseInt(dashboardPage.getElementText(dashboardPage.total_devices));
        int moving_vehicles = Integer.parseInt(dashboardPage.getElementText(dashboardPage.moving_vehicles));
        int idle_vehicles = Integer.parseInt(dashboardPage.getElementText(dashboardPage.idle_vehicles));
        int stopped_vehicles = Integer.parseInt(dashboardPage.getElementText(dashboardPage.stopped_vehicles));
        int unplugged_vehicles = Integer.parseInt(dashboardPage.getElementText(dashboardPage.unplugged_vehicles));
        int offline_vehicles = Integer.parseInt(dashboardPage.getElementText(dashboardPage.offline_vehicles));
        int not_connected_vehicles = Integer
                .parseInt(dashboardPage.getElementText(dashboardPage.not_connected_vehicles));

        int total_vehicles = moving_vehicles + idle_vehicles + stopped_vehicles + unplugged_vehicles
                + offline_vehicles + not_connected_vehicles;

        Assert.assertEquals(total_vehicles, total_devices,
                "Mismatch: Total Vehicles count does not match Total Devices");

        dashboardPage.clickOnElement(dashboardPage.user_profile);
        dashboardPage.clickOnElement(dashboardPage.logout_button);
    }
}