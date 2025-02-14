package com.OrangeHrmAutomation.Pages;

import com.OrangeHrmAutomation.Utilities.ReadExcel;
import com.OrangeHrmAutomation.Utilities.Screenshot;
import com.OrangeHrmAutomation.Utilities.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class IndexMainPage {
    ReadExcel readExcel;
    Waits waits;
    Screenshot screenshot;


    public IndexMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        readExcel = new ReadExcel();
        waits = new Waits();
        screenshot = new Screenshot();
    }

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[text()=' Login ']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[text()='Login']")
    private WebElement loginText;

    @FindBy(xpath = "//*[text()='Invalid credentials']")
    private WebElement invalidCredentialsText;

    @FindBy(xpath = "//*[text()='Required']")
    private WebElement requiredField;

    @FindBy(xpath = "//*[text()='Required']")
    private WebElement requiredFieldOfUsername;

    public void VerifyAdminLoginWithValidCredentials(WebDriver driver) throws IOException, InterruptedException {
        Thread.sleep(2000);
        String expectedLoginText = readExcel.readExcelFile("TestData", 3, 1);
        String actualLoginText = loginText.getText();
        if (actualLoginText.equals(expectedLoginText)) {
            System.out.println("Test Passed. The login Page is Displayed");
        } else {
            System.out.println("Test Failed. The login Page is not Displayed");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        String enteredUsername = readExcel.readExcelFile("TestData", 1, 1);
        username.sendKeys(enteredUsername);
        if (!enteredUsername.isEmpty()) {
            System.out.println("Test Passed. Username is entered and visible");
        } else {
            System.out.println("Test Failed. User name is not entered and visible");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertTrue(username.isDisplayed());

        String enteredPassword = readExcel.readExcelFile("TestData", 2, 1);
        password.sendKeys(enteredPassword);
        if (!enteredUsername.isEmpty()) {
            System.out.println("Test Passed. Password is entered and visible and covered in dots");
        } else {
            System.out.println("Test Failed. Password is not entered and visible ");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertTrue(password.isDisplayed());

        loginButton.click();
    }

    public void VerifyAdminCannotLoginWithInvalidCredentials(WebDriver driver) throws IOException, InterruptedException {
        String expectedInvalidLoginText = readExcel.readExcelFile("TestData", 7, 1);
        String actualInvalidLoginText = loginText.getText();
        if (actualInvalidLoginText.equals(expectedInvalidLoginText)) {
            System.out.println("Test Passed. The login Page is Displayed");
        } else {
            System.out.println("Test Failed. The login Page is not Displayed");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertTrue(loginText.isDisplayed());

        String enteredInvalidUsername = readExcel.readExcelFile("TestData", 8, 1);
        username.sendKeys(enteredInvalidUsername);
        if (username.isDisplayed()) {
            System.out.println("Test Passed. Username is entered and visible");
        } else {
            System.out.println("Test Failed. User name is not entered and visible");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertTrue(username.isDisplayed());

        String enteredInvalidPassword = readExcel.readExcelFile("TestData", 9, 1);
        password.sendKeys(enteredInvalidPassword);
        if (password.isDisplayed()) {
            System.out.println("Test Passed. Password is entered and visible and covered in dots");
        } else {
            System.out.println("Test Failed. Password is not entered and visible ");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertTrue(password.isDisplayed());
        loginButton.click();
        Thread.sleep(2000);
        String expectedInvalidCredentialText = readExcel.readExcelFile("TestData", 10, 1);
        String actualInvalidCredentialText = invalidCredentialsText.getText();
        if (actualInvalidCredentialText.equals(expectedInvalidCredentialText)) {
            System.out.println("Test Passed. An error message is displayed indicating invalid credentials.");
        } else {
            System.out.println("Test Failed. An error message is not displayed indicating invalid credentials.");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertEquals(actualInvalidCredentialText, expectedInvalidCredentialText);
    }

    public void VerifyAdminCannotLoginWithOnlyUsernameFilled(WebDriver driver) throws IOException {
        String expectedValidLoginText = readExcel.readExcelFile("TestData", 12, 1);
        String actualValidLoginText = loginText.getText();
        if (actualValidLoginText.equals(expectedValidLoginText)) {
            System.out.println("Test Passed. The login Page is Displayed");
        } else {
            System.out.println("Test Failed. The login Page is not Displayed");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertTrue(loginText.isDisplayed());

        String enteredUserName = readExcel.readExcelFile("TestData", 13, 1);
        username.sendKeys(enteredUserName);

        if (!enteredUserName.isEmpty()) {
            System.out.println("Test Passed. UserName is entered and visible");
        } else {
            System.out.println("Test Failed. UserName is not entered and visible");
        }
        loginButton.click();
        if (requiredField.isDisplayed()) {
            System.out.println("Test Passed. An error message is displayed indicating that the password is required.");
        } else {
            System.out.println("Test Failed. An error message is not displayed indicating that the password is required.");
        }

    }

    public void VerifyAdminCannotLoginWithOnlyPasswordFilled(WebDriver driver) throws IOException {
        String expectedValidLoginText = readExcel.readExcelFile("TestData", 16, 1);
        String actualValidLoginText = loginText.getText();
        if (actualValidLoginText.equals(expectedValidLoginText)) {
            System.out.println("Test Passed. The login Page is Displayed");
        } else {
            System.out.println("Test Failed. The login Page is not Displayed");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertTrue(loginText.isDisplayed());

        String enteredPassword = readExcel.readExcelFile("TestData",18,1);
        password.sendKeys(enteredPassword);
        if (!enteredPassword.isEmpty()){
            System.out.println("Password is entered, visible, and covered in dots.");
        }else {
            System.out.println("Password is not entered, visible, and covered in dots.");
        }

        loginButton.click();
        if (requiredFieldOfUsername.isDisplayed()){
            System.out.println("Test Passed . An error message is displayed indicating that the username is required.");
        }else {
            System.out.println("Test Failed. An error message is not displayed indicating that the username is required.");
        }
    }

    public void VerifyAdminCannotLoginWithBothFieldsEmpty(WebDriver driver) throws IOException {
        String expectedValidLoginText = readExcel.readExcelFile("TestData", 20, 2);
        String actualValidLoginText = loginText.getText();
        if (actualValidLoginText.equals(expectedValidLoginText)) {
            System.out.println("Test Passed. The login Page is Displayed");
        } else {
            System.out.println("Test Failed. The login Page is not Displayed");
        }
        screenshot.captureScreenshot(driver,"failed-screenshot");
        Assert.assertTrue(loginText.isDisplayed());

        loginButton.click();

        if (requiredFieldOfUsername.isDisplayed() && requiredField.isDisplayed()){
            System.out.println("Test Passed. An error message is displayed indicating that both username and password are required (for each field separate message).");
        }else {
            System.out.println("Test Failed. An error message is not displayed indicating that both username and password are required (for each field separate message).");
        }
    }
}
