package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "validLoginData")
    public static Object[][] validLoginData() {
        return new Object[][] {
                { "easytrax", "12345678" }
        };
    }

    @DataProvider(name = "invalidLoginData")
    public static Object[][] invalidLoginData() {
        return new Object[][] {
                { "easytrax", "1234567", "Unable to log in with provided credentials.", "", "" },
                { "foysal@292", "12345678", "Account with this email/username does not exists", "", "" },
                { "", "12345678", "", "Please fill in this field.", "" },
                { "easytrax", "", "", "", "Please fill in this field." },
                { "", "", "", "Please fill in this field.", "Please fill in this field." }
        };
    }

    @DataProvider(name = "validPasswordResetData")
    public static Object[][] validPasswordResetData() {
        return new Object[][] {
                { "foysal.easytrax@gmail.com",
                        "Instructions for resetting your password has been sent to your email. " +
                                "Please don't forget to check your spam folder as well." }
        };
    }

    @DataProvider(name = "invalidPasswordResetData")
    public static Object[][] invalidPasswordResetData() {
        return new Object[][] {
                { "foysal@easytrax", "No user found with this email id.", "" },
                { "afaysal410@gmail.com", "Email is not verified or email bounced, please contact support.", "" },
                { "afaysal", "", "Please include an '@' in the email address. 'afaysal' is missing an '@'." },
                { "afaysal@", "", "Please enter a part following '@'. 'afaysal@' is incomplete." },
                { "afaysal@.com", "", "'.' is used at a wrong position in '.com'." },
        };
    }
}