package com.task.automation.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer {

    private int retryCount = 0;

    private static final int MaxRetryCount = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MaxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
    public String getResultStatusName(int status) {
        String resultName = null;
        if(status==1)
            resultName = "SUCCESS";
        if(status==2)
            resultName = "FAILURE";
        if(status==3)
            resultName = "SKIP";
        return resultName;
    }


}
