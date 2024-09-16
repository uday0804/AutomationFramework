package com.task.automation.core;

import com.task.automation.enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class DriverManager {

    private WebDriver driver;

    private  static DriverType driverType;
    ConfigurationManager configurationManager = new ConfigurationManager();

    public DriverManager() {

        driverType=configurationManager.getBrowser();
    }

    public WebDriver getDriver(){
        //System.out.println("****************Driver*************"+configurationManager.properties.getProperty("firefox.driver.path"));
        if(driver == null)
        {
            driver = CreateDriver();

        }
        return driver;
    }

    public WebDriver CreateDriver()
    {
        switch (driverType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setAcceptInsecureCerts(true);
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("use-fake-ui-for-media-stream");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
                firefoxOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                firefoxOptions.addArguments("use-fake-ui-for-media-stream");
                //firefoxOptions.addPreference("permissions.default.microphone", 1);
                //firefoxOptions.addPreference("permissions.default.camera", 1);
                firefoxOptions.addPreference("media.navigator.permission.disabled", true);
                System.setProperty("webdriver.firefox.driver", configurationManager.properties.getProperty("firefox.driver.path"));
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }

    public void quitDriver()
    {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
