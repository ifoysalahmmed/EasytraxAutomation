package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    // Locators
    public By login_email = By.xpath("//input[@id='email']");
    public By login_password = By.xpath("//input[@id='password']");
    public By login_button = By.xpath("//button[contains(text(),'Sign In')]");
    public By error_message = By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/ul[1]/li[1]");

    // Methods
    public void navigateToLoginPage() {
        openPage(baseURL);
    }

    public String getErrorMessage(String errorMessage) {
        return errorMessage.isEmpty() ? "" : getElementText(error_message);
    }
}
