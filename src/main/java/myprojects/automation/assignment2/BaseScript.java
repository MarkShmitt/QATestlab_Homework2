package myprojects.automation.assignment2;

import myprojects.automation.assignment2.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {

    /**
     *
     * @return New instance of {@link WebDriver} object.
     */
    public static WebDriver getDriver() {
        // TODO return  WebDriver instance
        try {
             String browser = Properties.getBrowser();

             switch (browser) {
                 case "firefox":
                    System.setProperty("webdriver.gecko.driver", BaseScript.class.getResource("geckodriver.exe").getPath());
                    return new FirefoxDriver();
                 case "ie":
                    System.setProperty("webdriver.IE.driver", BaseScript.class.getResource("IEDriverServer.exe").getPath());
                    return new InternetExplorerDriver();
                 case "chrome":
                 default:
                    System.setProperty(
                        "webdriver.chrome.driver",
                        new File(BaseScript.class.getResource("/chromedriver.exe").getFile()).getPath());
                    return new ChromeDriver();
             }
        } catch (NullPointerException e) {
            throw new UnsupportedOperationException("Method doesn't return WebDriver instance");
        }
        }
    }

