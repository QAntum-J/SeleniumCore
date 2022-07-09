package com.framework.settings.webdriver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public abstract class WebDriverFactory {
    protected WebDriver driver;
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
