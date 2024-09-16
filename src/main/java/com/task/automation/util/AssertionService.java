package com.task.automation.util;

import com.task.automation.core.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.task.automation.core.BaseTest;
import com.task.automation.core.WaitService;
public class AssertionService extends BaseTest {
    WaitService wait = new WaitService(driver);

    public void assertElementPresent(WebElement elementLocator, long timeout)
    {
        wait.waitForElementPresent(elementLocator,timeout);
    }

    public void assertElementVisible(WebElement elementLocator,long timeout)
    {
        wait.waitForElementVisible(elementLocator, timeout);
    }

    public void verifyElementPresent(WebElement elementLocator, String SuccessMessage,String FailureMessage, long timeout)
    {
        try {
            wait.waitForElementPresent(elementLocator,timeout);
            Reporter.log(SuccessMessage);
        }
        catch (Exception e)
        {
            Reporter.log(FailureMessage);
        }
    }

    public void verifyElementVisible(WebElement elementLocator, String SuccessMessage,String FailureMessage, long timeout)
    {
        try {
            wait.waitForElementVisible(elementLocator,timeout);
            Reporter.log(SuccessMessage);
        }
        catch (Exception e)
        {
            Reporter.log(FailureMessage);
        }
    }

    public boolean isElementPresent(By by)
    {
        try {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public boolean verifyTrue(boolean b,String failMessage, String successMessage)
    {
        try {
            assertTrue(b, failMessage, successMessage);
            return true;
        }catch (Error e)
        {
            Reporter.log(e.toString());
        }
        return false;
    }

    public boolean verifyFalse(boolean b, String failMessage, String successMessage) {
        return verifyTrue(!b, failMessage, successMessage);
    }

    public void assertTrue(boolean b, String failMsg, String successMsg) {
        if (!b) {
            throw new AssertionError(failMsg);
        }
        Reporter.log("<br/>"+successMsg);
    }

    public void assertFalse(boolean b, String failMsg, String successMsg) {
        assertTrue(!b, failMsg, successMsg);
    }
}
