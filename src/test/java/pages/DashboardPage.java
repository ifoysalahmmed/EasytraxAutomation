package pages;

import org.openqa.selenium.By;

public class DashboardPage {

    public By user_profile = By.xpath ("//header/div[2]/div[2]/div[2]");
    public By logout_button = By.xpath ("//a[contains(text(),'Log Out')]");

}