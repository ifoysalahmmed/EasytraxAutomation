package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    HomePage homePage = new HomePage ();
    LoginPage loginPage = new LoginPage ();

    @BeforeMethod
    public void loadPage () {
        loginPage.navigateToLoginPage ();
    }

    @Test(dataProvider = "validLoginData", dataProviderClass = utilities.DataSet.class)
    public void test_login_with_valid_credentials (String email, String password){
        loginPage.writeOnElement (loginPage.login_email, email);
        loginPage.writeOnElement (loginPage.login_password, password);
        loginPage.clickOnElement (loginPage.login_button);
        loginPage.clickOnElement (homePage.user_profile);
        Assert.assertTrue (loginPage.getDisplayState (homePage.logout_button));
        Assert.assertFalse (loginPage.getDisplayState (loginPage.login_button));
    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = utilities.DataSet.class)
    public void test_login_with_invalid_credentials (String email, String password, String errorMessage,
                                                     String emailValidationMessage, String passwordValidationMessage) {
        loginPage.writeOnElement (loginPage.login_email, email);
        loginPage.writeOnElement (loginPage.login_password, password);
        loginPage.clickOnElement (loginPage.login_button);
        Assert.assertEquals (loginPage.getErrorMessage (errorMessage), errorMessage);
        Assert.assertEquals (loginPage.getAttribute (loginPage.login_email, "validationMessage"),
                emailValidationMessage);
        Assert.assertEquals (loginPage.getAttribute (loginPage.login_password, "validationMessage"),
                passwordValidationMessage);
        Assert.assertTrue (loginPage.getDisplayState (loginPage.login_button));
    }
}