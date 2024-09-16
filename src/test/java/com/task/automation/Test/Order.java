package com.task.automation.Test;

import com.task.automation.core.BaseTest;
import com.task.automation.pages.CartPage;
import com.task.automation.pages.DashBoardPage;
import com.task.automation.pages.SearchPage;
import com.task.automation.pages.SignInPage;
import com.task.automation.util.ExtentReport;
import org.testng.annotations.Test;

public class Order extends BaseTest {

    @Test(description = "Sign In and Order")
    public void ValidateOrderStatus() throws Exception{

        ExtentReport.extentLog = ExtentReport.extentReport.startTest("Validate Order Status","Validate Order and Sign in");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.SignInMethod();
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.SearchAnItems();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.SearchAndAddCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.CompleteCartTransaction();
    }
}
