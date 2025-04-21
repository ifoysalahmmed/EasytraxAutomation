package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.DriverSetup.getWebDriverThreadLocal;

public class BasePage {

    public String baseURL = "https://platform.easytrax.com.bd/auth";

    private WebDriverWait getWait() {
        return new WebDriverWait(getWebDriverThreadLocal(), Duration.ofSeconds(10));
    }

    // Navigation methods
    public void openPage(String URL) {
        getWebDriverThreadLocal().get(URL);
    }

    // Element interaction methods
    public WebElement getWebElement(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickOnElement(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void writeOnElement(By locator, String text) {
        WebElement element = getWebElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Element state and attribute methods
    public Boolean getDisplayState(By locator) {
        try {
            return getWebDriverThreadLocal().findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getAttribute(By locator, String attribute) {
        return getWebElement(locator).getDomAttribute(attribute);
    }

    public String getElementText(By locator) {
        return getWebElement(locator).getText();
    }
}