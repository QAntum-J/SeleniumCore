package com.framework.settings.webdriver.manager;

import com.data.enums.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class GeckoDriverManager extends WebDriverManager {
    @Override
    protected void setUpDriverOptions(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");
        if (headless) options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
    }

    @Override
    protected void locateDriver() {
        System.setProperty("webdriver.gecko.driver", propertyFileReader.getDriverPath(WebDriver.GECKO));
    }

    @Override
    protected void tearDownDriver() {
        driver.quit();
    }
}
