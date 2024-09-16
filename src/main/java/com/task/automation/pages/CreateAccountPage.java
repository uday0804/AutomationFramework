package com.task.automation.pages;

import com.task.automation.core.WaitService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.task.automation.util.StringUtil;
import org.testng.Assert;
import com.task.automation.core.WaitService;

import java.io.IOException;
import java.time.Duration;

public class CreateAccountPage {

    WebDriver driver;
    WebDriverWait Wait;

    public CreateAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        Wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void CreateAccountMethod() throws IOException, Exception{
        CreateAccountPage createAccount = new CreateAccountPage(driver);
        createAccount.CreateLink.click();
        createAccount.FirstName.sendKeys("Uday");
        createAccount.LastName.sendKeys("kandimalla");
        String randomEmail = StringUtil.CreateRandomString("user")+"@gmail.com";
        String randomPass = StringUtil.CreateRandomString("Pass");
        System.out.println(randomEmail);
        System.out.println(randomPass);
        createAccount.Email.sendKeys(randomEmail);
        createAccount.Password.sendKeys(randomPass);
        createAccount.ConfirmPassword.sendKeys(randomPass);
        createAccount.CreateAccountButton.submit();
        Thread.sleep(5000);
        String actualMessage = createAccount.SuccessAccountCreationMessage.getText();
        Assert.assertEquals(actualMessage,"Thank you for registering with Main Website Store.");
    }


    @FindBy(linkText = "Create an Account")
    public  WebElement CreateLink;

    @FindBy(id = "firstname")
    public  WebElement FirstName;

    @FindBy(name="lastname")
    public WebElement LastName;

    @FindBy(xpath = "//input[@id='email_address']")
    public WebElement Email;

    @FindBy(name = "password")
    public WebElement Password;

    @FindBy(name = "password_confirmation")
    public WebElement ConfirmPassword;

    @FindBy(xpath = "//button[@title='Create an Account']")
    public WebElement CreateAccountButton;

    @FindBy(xpath = "//div[contains(text(),'Thank you for registering with Main Website Store.')]")
    public WebElement SuccessAccountCreationMessage;

}
