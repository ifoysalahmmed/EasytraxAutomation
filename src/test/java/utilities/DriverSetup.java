package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverSetup {

    public static final String BROWSER_NAME = System.getProperty ("browser", "Chrome");
    private static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = new ThreadLocal<> ();

    public static WebDriver getWebDriverThreadLocal () {
        return WEB_DRIVER_THREAD_LOCAL.get ();
    }

    public static void setWebDriverThreadLocal (WebDriver driver) {
        DriverSetup.WEB_DRIVER_THREAD_LOCAL.set (driver);
    }

    public static WebDriver getBrowser (String browserName) {
        if (browserName.equalsIgnoreCase ("chrome")) {
            return new ChromeDriver ();
        } else if (browserName.equalsIgnoreCase ("firefox")) {
            return new FirefoxDriver ();
        } else if (browserName.equalsIgnoreCase ("edge")) {
            return new EdgeDriver ();
        } else if (browserName.equalsIgnoreCase ("safari")) {
            return new SafariDriver ();
        } else {
            throw new AssertionError ("Unsupported browser: " + browserName);
        }
    }

    @BeforeMethod
    public void setBrowserName () {
        WebDriver driver = getBrowser (BROWSER_NAME);
        driver.manage ().window ().maximize ();
        driver.manage ().deleteAllCookies ();
        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (15));
        setWebDriverThreadLocal (driver);
    }

    @AfterMethod
    public void quitBrowser () {
        WebDriver driver = getWebDriverThreadLocal ();
        if (driver != null) {
            driver.quit ();
            WEB_DRIVER_THREAD_LOCAL.remove ();
        }
    }
}