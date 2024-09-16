package com.task.automation.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

public class ExtentReport {

    public static ExtentReports extentReport = null;
    public static ExtentTest extentLog;

    public static void initialize(String path)
    {
        if(extentReport == null)
        {
            extentReport = new ExtentReports(path,true);
            extentReport.addSystemInfo("Host Name",System.getProperty("user.name"));
            extentReport.addSystemInfo("Environment","QA");
            extentReport.loadConfig(new File(System.getProperty("user.dir") + "resources/extent-config.xml"));

        }
    }

    public static void setInstanceNull(){extentReport =null;}

    public static void ExtentReportInfoLog(String message){
        extentLog.log(LogStatus.INFO,message);
    }

    public static void ExtentReportErrorLog(String message){
        extentLog.log(LogStatus.ERROR, message);
    }
}
