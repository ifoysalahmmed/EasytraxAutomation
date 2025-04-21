package pages;

import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    // User Profile and Logout
    public By user_profile = By.xpath("//header/div[2]/div[2]/div[2]");
    public By logout_button = By.xpath("//a[contains(text(),'Log Out')]");

    // Vehicle Statistics
    public By total_devices = By.xpath("//p[text()='Total Devices']/parent::div/span[@class='stat__value']");
    public By moving_vehicles = By.xpath("//p[normalize-space()='Moving']/parent::div/span[@class='stat__value']");
    public By idle_vehicles = By.xpath("//p[normalize-space()='Idle']/parent::div/span[@class='stat__value']");
    public By stopped_vehicles = By.xpath("//p[normalize-space()='Engine Off']/parent::div/span[@class='stat__value']");
    public By unplugged_vehicles = By
            .xpath("//p[normalize-space()='Unplugged']/parent::div/span[@class='stat__value']");
    public By offline_vehicles = By
            .xpath("//p[normalize-space()='Unreachable']/parent::div/span[@class='stat__value']");
    public By not_connected_vehicles = By
            .xpath("//p[normalize-space()='Not Connected']/parent::div/span[@class='stat__value']");
}
