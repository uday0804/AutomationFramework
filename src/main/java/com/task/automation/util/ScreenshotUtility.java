package com.task.automation.util;

import com.task.automation.core.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtility extends BaseTest {

    public static void captureScreenshot(WebDriver driver,String ScreenshotName)
    {
        try{
            Thread.sleep(10000);
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
            System.setProperty("org.uncommons.reportng.escape-output", "true");
            File destinationPath = new File(".//target//surefire-reports//screenshots/" + ScreenshotName + ".png");
            FileUtils.copyFile(source,destinationPath);

        }
        catch (Exception ex)
        {
            throw new RuntimeException(
                    "Destination File path is incorrect");
        }
    }
}
