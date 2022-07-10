package com.framework.settings.webdriver.manager;

import com.data.enums.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends WebDriverManager{
    @Override
    protected void setUpDriverOptions(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        if (headless) options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Override
    protected void locateDriver() {
        System.setProperty("webdriver.chrome.driver", propertyFileReader.getDriverPath(WebDriver.CHROME));
    }

    @Override
    protected void tearDownDriver() {
        driver.quit();
    }
}
