package com.task.automation.core;

import com.task.automation.enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {

    public Properties properties;
    String propertyFile = "src/main/resources/configuration.properties";

    public ConfigurationManager()
    {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(propertyFile));
            properties = new Properties();
            try
            {
                properties.load(reader);
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at" + propertyFile);

        }
    }

    public DriverType getBrowser()
    {
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            return DriverType.CHROME;
        } else if (browserName.equalsIgnoreCase("firefox")) {
            return  DriverType.FIREFOX;
        }
        else
            throw new RuntimeException(
                    "Please provide valid browser value from configuration.properties file, accepted browser are: chrome, firefox, IE:"+browserName
            );
    }
}
