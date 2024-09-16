package com.task.automation.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.task.automation.core.Reporter;

import java.time.Duration;

public class WaitService {

    private WebDriver driver;

    public WaitService(WebDriver driver)
    {
        this.driver = driver;
    }

    public void waitForElementVisible(WebElement element, long timeout)
    {
        try{
            new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e)
        {
            Reporter.log(element.toString() + "is not visible");
            Reporter.log(e.getStackTrace().toString());
        }
    }

    public void waitForElementPresent(WebElement element,long timeOut)
    {
        try{
            new WebDriverWait(driver,Duration.ofSeconds(timeOut)).until(ExpectedConditions.presenceOfElementLocated((By) element));

        } catch (NoSuchElementException e)
        {
            Reporter.log(element.toString() + "is not present");
            Reporter.log(e.getStackTrace().toString());
        }
    }
}
