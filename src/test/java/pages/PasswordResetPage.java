package pages;

import org.openqa.selenium.By;

public class PasswordResetPage extends BasePage {

    public By forgot_password = By.xpath ("//a[contains(text(),'Forgot / Reset Password')]");
    public By password_reset_email = By.xpath ("//input[@id='email']");
    public By password_reset_button = By.xpath ("//button[contains(text(),'Next')]");
    public By success_message = By.xpath ("//p[contains(text(),'Instructions for resetting your password has been ')]");
    public By error_message = By.xpath ("//li[@class='error-item']");

    public void navigateToLoginPage () {
        openPage (baseURL);
    }

    public String getErrorMessage (String errorMessage) {
        if (errorMessage.isEmpty ()) {
            return "";
        } else {
            return getElementText (error_message);
        }
    }

    public String getSuccessMessage (String successMessage) {
        return getElementText (success_message);
    }
}