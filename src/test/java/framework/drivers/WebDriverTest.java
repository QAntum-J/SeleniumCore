package framework.drivers;

import com.framework.settings.readers.PropertyFileReader;
import com.framework.settings.webdriver.factory.WebDriverFactory;
import com.framework.settings.webdriver.manager.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.data.enums.Environment.*;
import static com.data.enums.WebDriver.*;

public class WebDriverTest {

    /*
        - In order to tun this tests, please get chromedriver, geckodriver and msedgedriver by your own
        - Put you WebDrivers in directory WebDriver (Content Root)
        - WebDrivers should be named by default (chromedriver, geckodriver, msedgedriver)
        - You can change the names or the path of the WebDrivers, however firstly you should modify data in Framework.properties
          file.
    */

    WebDriverManager webDriverManager;
    WebDriver driver;
    PropertyFileReader propertyFileReader;

    @Test(priority = 1)
    public void runChromeDriverHeadlessFalse(){
        webDriverManager = WebDriverFactory.initializeDriver(CHROME);
        driver = webDriverManager.getDriver(false);
        propertyFileReader = new PropertyFileReader();
        String environmentURL = propertyFileReader.getEnvironmentURL(DEV);
        driver.get(environmentURL);
        webDriverManager.killDriverInstance();
    }

    @Test(priority = 2)
    public void runChromeDriverHeadlessTrue(){
        webDriverManager = WebDriverFactory.initializeDriver(CHROME);
        driver = webDriverManager.getDriver(true);
        propertyFileReader = new PropertyFileReader();
        String environmentURL = propertyFileReader.getEnvironmentURL(DEV);
        driver.get(environmentURL);
        webDriverManager.killDriverInstance();
    }

    @Test(priority = 3)
    public void runGeckoDriverHeadlessFalse(){
        webDriverManager = WebDriverFactory.initializeDriver(GECKO);
        driver = webDriverManager.getDriver(false);
        propertyFileReader = new PropertyFileReader();
        String environmentURL = propertyFileReader.getEnvironmentURL(DEV);
        driver.get(environmentURL);
        webDriverManager.killDriverInstance();
    }

    @Test(priority = 4)
    public void runGeckoDriverHeadlessTrue(){
        webDriverManager = WebDriverFactory.initializeDriver(GECKO);
        driver = webDriverManager.getDriver(true);
        propertyFileReader = new PropertyFileReader();
        String environmentURL = propertyFileReader.getEnvironmentURL(DEV);
        driver.get(environmentURL);
        webDriverManager.killDriverInstance();
    }

    @Test(priority = 5)
    public void runEdgeDriverHeadlessFalse(){
        webDriverManager = WebDriverFactory.initializeDriver(EDGE);
        driver = webDriverManager.getDriver(false);
        propertyFileReader = new PropertyFileReader();
        String environmentURL = propertyFileReader.getEnvironmentURL(DEV);
        driver.get(environmentURL);
        webDriverManager.killDriverInstance();
    }

    @Test(priority = 6)
    public void runEdgeDriverHeadlessTrue(){
        webDriverManager = WebDriverFactory.initializeDriver(EDGE);
        driver = webDriverManager.getDriver(true);
        propertyFileReader = new PropertyFileReader();
        String environmentURL = propertyFileReader.getEnvironmentURL(DEV);
        driver.get(environmentURL);
        webDriverManager.killDriverInstance();
    }

}
