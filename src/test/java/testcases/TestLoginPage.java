package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
        loginPage.navigateToLoginPage();
    }

    @Test(dataProvider = "validLoginData", dataProviderClass = utilities.DataSet.class)
    public void testLoginWithValidCredentials(String email, String password) {
        loginPage.writeOnElement(loginPage.login_email, email);
        loginPage.writeOnElement(loginPage.login_password, password);
        loginPage.clickOnElement(loginPage.login_button);
        loginPage.clickOnElement(dashboardPage.user_profile);

        Assert.assertTrue(loginPage.getDisplayState(dashboardPage.logout_button));
        Assert.assertFalse(loginPage.getDisplayState(loginPage.login_button));
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = utilities.DataSet.class)
    public void testLoginWithInvalidCredentials(String email, String password, String errorMessage,
            String emailValidationMessage, String passwordValidationMessage) {
        loginPage.writeOnElement(loginPage.login_email, email);
        loginPage.writeOnElement(loginPage.login_password, password);
        loginPage.clickOnElement(loginPage.login_button);

        Assert.assertEquals(loginPage.getErrorMessage(errorMessage), errorMessage);
        Assert.assertEquals(loginPage.getAttribute(loginPage.login_email, "validationMessage"),
                emailValidationMessage);
        Assert.assertEquals(loginPage.getAttribute(loginPage.login_password, "validationMessage"),
                passwordValidationMessage);
        Assert.assertTrue(loginPage.getDisplayState(loginPage.login_button));
    }
}