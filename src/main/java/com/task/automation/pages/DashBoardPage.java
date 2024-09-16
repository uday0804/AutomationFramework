package com.task.automation.pages;

import com.task.automation.core.WaitService;
import com.task.automation.util.JsonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class DashBoardPage {

    WebDriver driver;
    WebDriverWait wait;
    WaitService ElementWait;
    public DashBoardPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void SearchAnItems() throws IOException, Exception
    {
        Map<String,Object> Dashboarddata = JsonUtil.getTestData("SearchOperations");
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='store logo']")));
        dashBoardPage.SearchButton.click();
        dashBoardPage.SearchButton.clear();;
        String SearchInput = (String) Dashboarddata.get("SearchInput");
        dashBoardPage.SearchButton.sendKeys(SearchInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_autocomplete")));
        WebElement dropDown = driver.findElement(By.id("search_autocomplete"));
        List<WebElement> searchResults = dropDown.findElements(By.xpath("//ul[@role='listbox']/li/span[contains(@class, 'qs-option-name')]"));
        for (WebElement result: searchResults){
            System.out.println(result.getText());
            if(result.getText().toLowerCase().contains(SearchInput.toLowerCase()))
            {
                result.click();
                break;
            }
        }
        Thread.sleep(2000);

    }

    @FindBy(xpath = "//input[@id='search']")
    public WebElement SearchButton;

    @FindBy(linkText = "Sale")
    public WebElement SaleLink;

    @FindBy(linkText = "Training")
    public WebElement TrainingLink;

    @FindBy(linkText = "Gear")
    public WebElement GearLink;

    @FindBy(linkText = "Men")
    public WebElement MenLink;

    @FindBy(linkText = "Women")
    public  WebElement WomenLink;


}
