package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.DriverSetup.getWebDriverThreadLocal;

public class BasePage {

    public String baseURL = "https://platform.easytrax.com.bd/auth";

    private WebDriverWait getWait () {
        return new WebDriverWait (getWebDriverThreadLocal (), Duration.ofSeconds (10));
    }

    public WebElement getWebElement (By locator) {
        return getWait ().until (ExpectedConditions.presenceOfElementLocated (locator));
    }

    public void clickOnElement (By locator) {
        getWait ().until (ExpectedConditions.elementToBeClickable (locator)).click ();
    }

    public void openPage (String URL) {
        getWebDriverThreadLocal ().get (URL);
    }

    public void writeOnElement (By locator, String text) {
        getWebElement (locator).clear ();
        getWebElement (locator).sendKeys (text);
    }

    public Boolean getDisplayState (By locator) {
        try {
            return getWebDriverThreadLocal ().findElement (locator).isDisplayed ();
        } catch (Exception e) {
            return false;
        }
    }

    public String getAttribute (By locator, String attribute) {
        return getWebElement (locator).getAttribute (attribute);
    }

    public String getElementText (By locator) {
        return getWebElement (locator).getText ();
    }
}