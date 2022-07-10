package com.framework.settings.readers;

import com.data.enums.Environment;
import com.data.enums.WebDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/main/java/com/data/properties/Framework.properties";

    public PropertyFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(WebDriver webDriver){
        String driverPath;
        switch (webDriver) {
            case CHROME -> driverPath = properties.getProperty("ChromeDriverPath");
            case GECKO  -> driverPath = properties.getProperty("GeckoDriverPath");
            case EDGE   -> driverPath = properties.getProperty("EdgeDriverPath");
            default     -> driverPath = null;
        }
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("Driver Path not specified in the Framework.properties file.");
    }

    public String getEnvironmentURL(Environment environment){
        String environmentURL;
        switch (environment){
            case DEV   -> environmentURL = properties.getProperty("DevURL");
            case STAGE -> environmentURL = properties.getProperty("StageURL");
            case PROD  -> environmentURL = properties.getProperty("ProdURL");
            default    -> environmentURL = null;
        }
        if (environmentURL != null) return environmentURL;
        else throw new RuntimeException("Environment URL not specified in the Framework.properties file.");
    }
}
