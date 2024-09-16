package com.task.automation.pages;

import com.google.gson.JsonObject;
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

public class SignInPage {

    WebDriver driver;
    WebDriverWait wait;

    public SignInPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void SignInMethod() throws IOException,Exception
    {
        Map<String,Object> loginData = JsonUtil.getTestData("loginCredentials");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.SingInLink.click();
        String email = (String) loginData.get("email");
        String password = (String)loginData.get("password");
        signInPage.email.sendKeys(email);
        signInPage.password.sendKeys(password);
        signInPage.SignInButton.submit();
        Thread.sleep(2000);
        String GreetMessage = signInPage.GreetText.getText();
        String ExpectedMessage = (String) loginData.get("greetMessage");
        Assert.assertEquals(GreetMessage,ExpectedMessage);
    }

    @FindBy(linkText = "Sign In")
    public WebElement SingInLink;

    @FindBy(name = "login[username]")
    public WebElement email;

    @FindBy(name="login[password]")
    public WebElement password;

    @FindBy(name = "send")
    public WebElement SignInButton;

    @FindBy(xpath = "(//span[contains(text(),'Welcome, uday kandimalla!')])[1]")
    public WebElement GreetText;
}
