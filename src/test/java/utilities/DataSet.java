package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name="validLoginData")
    public static Object[][] validLoginData () {
        return new Object[][] {
                {"easytrax", "12345678"}
        };
    }

    @DataProvider(name="invalidLoginData")
    public static Object[][] invalidLoginData () {
        return new Object[][] {
                {"easytrax","1234567","non_field_errors: Unable to log in with provided credentials.", "", ""},
                {"foysal@29", "12345678", "non_field_errors: Account with this email/username does not exists", "", ""},
                {"", "12345678", "", "Please fill in this field.", ""},
                {"easytrax", "", "", "", "Please fill in this field."},
                {"", "", "", "Please fill in this field.", "Please fill in this field."}
        };
    }
}