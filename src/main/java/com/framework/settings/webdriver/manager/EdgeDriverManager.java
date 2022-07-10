package com.framework.settings.webdriver.manager;

import com.data.enums.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager extends WebDriverManager{
    @Override
    protected void setUpDriverOptions(boolean headless) {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("-inprivate");
        if(headless) options.addArguments("-headless");
        driver = new EdgeDriver(options);
        driver.manage().window().maximize();
    }

    @Override
    protected void locateDriver() {
        System.setProperty("webdriver.edge.driver", propertyFileReader.getDriverPath(WebDriver.EDGE));
    }

    @Override
    protected void tearDownDriver() {
        driver.quit();
    }
}
