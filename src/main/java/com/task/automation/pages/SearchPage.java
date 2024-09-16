package com.task.automation.pages;

import com.task.automation.core.WaitService;
import com.task.automation.util.JsonUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void SearchAndAddCart() throws IOException, Exception{

        Map<String,Object> SearchPageData = JsonUtil.getTestData("SearchPageData");

        SearchPage searchPage = new SearchPage(driver);
        String ActualMessage = searchPage.SearchResultsMessage.getText();
        String SearchExpected = (String) SearchPageData.get("SearchExpected");
        Assert.assertEquals(ActualMessage,SearchExpected);
        Thread.sleep(2000);
        searchPage.HeroHoodie.click();
        WaitService waitService = new WaitService(driver);
        waitService.waitForElementVisible(SelectSizeS,60);
        searchPage.SelectSizeS.click();
        searchPage.SelectColorGreen.click();
        searchPage.AddToCartButton.click();
    }

    @FindBy(xpath = "//span[contains(text(),'Search results for:')]")
    public WebElement SearchResultsMessage;

    @FindBy(xpath = "(//a[@href='https://magento.softwaretestingboard.com/hero-hoodie.html\'])[1]")
    public WebElement HeroHoodie;

    @FindBy(xpath = "//div[@option-label='S']")
    public WebElement SelectSizeS;

    @FindBy(xpath = "//div[@option-label='Green']")
    public WebElement SelectColorGreen;

    @FindBy(id = "product-addtocart-button")
    public WebElement AddToCartButton;


}
