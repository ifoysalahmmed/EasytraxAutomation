package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PasswordResetPage;
import utilities.DriverSetup;

public class TestPasswordResetPage extends DriverSetup {

    private PasswordResetPage passwordResetPage = new PasswordResetPage();

    @BeforeMethod
    public void loadPage() {
        passwordResetPage.navigateToLoginPage();
        passwordResetPage.clickOnElement(passwordResetPage.forgot_password);
    }

    @Test(dataProvider = "validPasswordResetData", dataProviderClass = utilities.DataSet.class)
    public void test_password_reset_with_valid_email(String email, String successMessage) {
        passwordResetPage.writeOnElement(passwordResetPage.password_reset_email, email);
        passwordResetPage.clickOnElement(passwordResetPage.password_reset_button);
        Assert.assertEquals(passwordResetPage.getSuccessMessage(successMessage), successMessage);
    }

    @Test(dataProvider = "invalidPasswordResetData", dataProviderClass = utilities.DataSet.class)
    public void test_password_reset_with_invalid_email(String email, String errorMessage,
            String emailValidationMessage) {
        passwordResetPage.writeOnElement(passwordResetPage.password_reset_email, email);
        passwordResetPage.clickOnElement(passwordResetPage.password_reset_button);
        Assert.assertEquals(passwordResetPage.getErrorMessage(errorMessage), errorMessage);
        Assert.assertEquals(passwordResetPage.getAttribute(passwordResetPage.password_reset_email, "validationMessage"),
                emailValidationMessage);
        Assert.assertTrue(passwordResetPage.getDisplayState(passwordResetPage.password_reset_button));
    }
}