package com.framework.settings.webdriver.factory;

import com.data.enums.WebDriver;
import com.framework.settings.webdriver.manager.ChromeDriverManager;
import com.framework.settings.webdriver.manager.EdgeDriverManager;
import com.framework.settings.webdriver.manager.GeckoDriverManager;
import com.framework.settings.webdriver.manager.WebDriverManager;
import org.openqa.selenium.WebDriverException;

public abstract class WebDriverFactory {
    public static WebDriverManager initializeDriver(WebDriver webDriver){
        WebDriverManager webDriverManager;
        switch (webDriver){
            case CHROME -> webDriverManager = new ChromeDriverManager();
            case GECKO  -> webDriverManager = new GeckoDriverManager();
            case EDGE   -> webDriverManager = new EdgeDriverManager();
            default     -> webDriverManager = null;
        }
        if(webDriverManager != null) return webDriverManager;
        else throw new WebDriverException("Not existing WebDriver has been chosen");
    }

}
