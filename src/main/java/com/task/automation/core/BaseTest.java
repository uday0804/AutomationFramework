package com.task.automation.core;


import com.relevantcodes.extentreports.LogStatus;
import com.task.automation.util.ExtentReport;
import com.task.automation.util.ScreenshotUtility;
import com.task.automation.util.StringUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;
import org.testng.ITestResult;

import java.io.IOException;
import com.task.automation.core.DriverManager;
import java.util.Date;

public class BaseTest {
    static Date now = new Date();
    public static String TimeStamp = now.toString().replace(":", "-");
    public static WebDriver driver;

    DriverManager driverManager = new DriverManager();

    public  static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Parameters({ "ReportName", "FlowType" })
    @BeforeSuite(alwaysRun = true)
    public void config(@Optional("Optional name Automation ") String reportname, @Optional("Automation Report") String flow)
            throws IOException {

        ExtentReport.initialize(System.getProperty("user.dir")+"/results/"+ TimeStamp+" UI_Report.html");
        // Log path
        //	utils.Logging.setLogPath("LocusApi_logs.log");

        // create logging instance
        //	log = Logging.getInstance();

    }

    @BeforeTest
    public void beforeTest() {
        driver = driverManager.getDriver();
        driver.navigate().to(baseUrl);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        System.out.printf("Test case", "*********************************************************************");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {

			/*if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println(result.getMethod().getMethodName()+" :Passed");
			}
			else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println(result.getMethod().getMethodName()+" :Failed");
			}
			else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println(result.getMethod().getMethodName()+" :Skipped");
			}
			*/
        //Reporter.log("<a href=\"" + "screenshotfile" +"\" target=\"_blank\">View Screenshot</a><br>");
        if (result.getStatus() == ITestResult.SUCCESS) {
            ExtentReport.extentLog.log(LogStatus.PASS.PASS, "Test Case: " + result.getName()+" is passed " );

        } else if (result.getStatus() == ITestResult.FAILURE) {
            ExtentReport.extentLog.log(LogStatus.FAIL, "Test case: " + result.getName() + " is failed");
            ExtentReport.extentLog.log(LogStatus.FAIL, "Test case is failed " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            ExtentReport.extentLog.log(LogStatus.SKIP, "Test case is Skiped " );
        }
        ExtentReport.extentReport.endTest(ExtentReport.extentLog);
        //--------------
        String methodName= StringUtil.CreateRandomString(result.getMethod().getMethodName());
        System.out.println("METHOD........"+methodName);
        ScreenshotUtility.captureScreenshot(driver,methodName);
        //Reporter.setCurrentTestResult(result);

    }

    @AfterTest
    public void afterTest() {
        driverManager.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void endReport() {
        //ExtentReport.extentreport.flush();
        ExtentReport.extentReport.close();
        System.out.println("Close ExtentReport");
        //Email.sendEmail();

    }

}
