package com.task.automation.core;

import org.apache.logging.log4j.Logger;
import org.testng.*;
public class TestListner implements ISuiteListener, ITestListener, IInvokedMethodListener {

    static  Logger logger;

    @Override
    public void onStart(ISuite suite) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onFinish(ISuite suite) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        logger.debug("onTestStart: start");
        System.out.println("Started..." + result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println(result.getMethod().getMethodName() + " :Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println(result.getMethod().getMethodName() + " :Failed");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println(result.getMethod().getMethodName() + " :Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }

}
