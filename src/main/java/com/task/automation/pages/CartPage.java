package com.task.automation.pages;

import com.task.automation.util.JsonUtil;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void CompleteCartTransaction() throws IOException, Exception{
        Map<String,Object> CartPageData = JsonUtil.getTestData("CartPageData");
        String StreetOne = (String) CartPageData.get("StreetOne");
        String StreetTwo = (String) CartPageData.get("StreetTwo");
        String City = (String) CartPageData.get("City");
        String Sstate = (String) CartPageData.get("State");
        String Zip = (String) CartPageData.get("zip");
        String PhoneNum = (String) CartPageData.get("Phone");
        String OrderConfirmation = (String) CartPageData.get("Message");
        CartPage cartPage = new CartPage(driver);
        Thread.sleep(2000);
        cartPage.CartLocator.click();
        cartPage.ProceedCheckOutLocator.click();
        cartPage.StreetOneLoc.sendKeys(StreetOne);
        cartPage.StreetTwoLoc.sendKeys(StreetTwo);
        cartPage.City.sendKeys(City);
        Select select = new Select(State);
        select.selectByVisibleText(Sstate);
        cartPage.zipCode.sendKeys(Zip);
        cartPage.phoneNum.sendKeys(PhoneNum);
        cartPage.ShippingLocator.click();
        cartPage.NextLocator.click();
        cartPage.PlaceOrderLoc.click();
        String OrderConfirmaton = cartPage.OrderConfirmationMessage.getText();
        Assert.assertEquals(OrderConfirmaton,OrderConfirmation);
    }

    @FindBy(xpath = "(//span[contains(text(),'My Cart')])[1]")
    public WebElement CartLocator;

    @FindBy(id = "top-cart-btn-checkout")
    public WebElement ProceedCheckOutLocator;

    @FindBy(name = "street[0]")
    public WebElement StreetOneLoc;

    @FindBy(name = "street[1]")
    public WebElement StreetTwoLoc;

    @FindBy(name = "city")
    public WebElement City;

    @FindBy(name = "region_id")
    public WebElement State;

    @FindBy(name = "postcode")
    public WebElement zipCode;

    @FindBy(name = "telephone")
    public WebElement phoneNum;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement ShippingLocator;

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    public WebElement NextLocator;

    @FindBy(xpath = "//button[@title='Place Order']")
    public WebElement PlaceOrderLoc;

    @FindBy(xpath = "//span[contains(text(),'Thank you for your purchase!')]")
    public WebElement OrderConfirmationMessage;
}
