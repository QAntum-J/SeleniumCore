package com.framework.settings.webdriver.manager;

import com.framework.settings.readers.PropertyFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public abstract class WebDriverManager {
    protected WebDriver driver;
    protected PropertyFileReader propertyFileReader = new PropertyFileReader();
    protected abstract void setUpDriverOptions(boolean headless);
    protected abstract void locateDriver();
    protected abstract void tearDownDriver();

    public WebDriver getDriver(boolean headless){
        if (driver == null){
            locateDriver();
            setUpDriverOptions(headless);
            return driver;
        }
        else throw new WebDriverException("Previous driver instance is still running");
    }

    public void killDriverInstance(){
        if (driver != null){
            tearDownDriver();
        }
        else throw new WebDriverException("Current Driver Instance is null");
    }
}
