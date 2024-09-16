package com.task.automation.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.task.automation.core.BaseTest;
import com.task.automation.pages.SignInPage;
import com.task.automation.util.ExtentReport;
import org.testng.annotations.Test;

public class SignIn extends BaseTest {

    @Test(description = "Validate Sign In")
    public void ValidateSignIn() throws Exception
    {
        ExtentReport.extentLog = ExtentReport.extentReport.startTest("Validate Sign In", "Validate Sign in");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.SignInMethod();
    }

}
