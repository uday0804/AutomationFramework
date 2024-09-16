package com.task.automation.Test;

import com.task.automation.core.BaseTest;
import com.task.automation.util.ExtentReport;
import org.testng.annotations.Test;
import com.task.automation.pages.CreateAccountPage;

public class CreateAccount extends BaseTest {

    @Test(description = "Verify Create Account Test")
    public void verifyCreateAccount() throws Exception
    {
        ExtentReport.extentLog = ExtentReport.extentReport.startTest("Verify Create Account","Verify Create Account Test");
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.CreateAccountMethod();
    }
}
