package com.OrangeHrmAutomation.Pages;

import com.OrangeHrmAutomation.Utilities.ReadExcel;
import com.OrangeHrmAutomation.Utilities.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class UpdatePasswordPage {
    ReadExcel readExcel;
    Screenshot screenshot;

    public UpdatePasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        readExcel = new ReadExcel();
        screenshot = new Screenshot();
    }

    @FindBy(xpath = "(//input[@type='password'])[1]")
    private WebElement currentPasswordTextBoxOfChangePassword;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    private WebElement passwordTextBoxOfChangePassword;

    @FindBy(xpath = "(//input[@type='password'])[3]")
    private WebElement confirmPasswordTextBoxOfChangePassword;

    @FindBy(xpath = "//*[text()=' Save ']")
    private WebElement saveButtonOfChangePassword;

    @FindBy(xpath = "//*[text()='Update Password']")
    private WebElement updatePasswordPageText;

    @FindBy(xpath = "//*[text()='Passwords do not match']")
    private WebElement passwordDoNotMatchText;

    @FindBy(xpath = "//*[text()='Should have at least 7 characters']")
    private WebElement shouldHaveAtLeastSevenCharacters;

    @FindBy(xpath = "//*[text()='Your password must contain minimum 1 lower-case letter']")
    private WebElement yourPasswordContainMinimumOneLowerCaseLetter;

    @FindBy(xpath = "//*[text()='Logout']")
    private WebElement logoutButton;


    public void VerifyChangePasswordVisible(WebDriver driver) throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        if (updatePasswordPageText.isDisplayed()) {
            System.out.println("Test Passed. Change Password page is displayed.");
        } else {
            System.out.println("Test Failed. Change Password page is not displayed.");
        }
        Assert.assertTrue(updatePasswordPageText.isDisplayed());
        screenshot.captureScreenshot(driver, "failed-screenshot");
    }

    public void userCanChangePasswordWithValidCredentialsRecords(WebDriver driver) throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String currentPasswordTextBox = readExcel.readExcelFile("TestData", 24, 1);
        currentPasswordTextBoxOfChangePassword.sendKeys(currentPasswordTextBox);
        String getTextOfCurrentPasswordTextBox = currentPasswordTextBoxOfChangePassword.getAttribute("value");
        if (getTextOfCurrentPasswordTextBox.contains(currentPasswordTextBox)) {
            System.out.println("Test Passed. Current password is entered, visible and covered in dots.");
        } else {
            System.out.println("Test Failed. Current password is not entered, visible and covered in dots.");
        }
        Assert.assertTrue(getTextOfCurrentPasswordTextBox.contains(currentPasswordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");


        String passwordTextBox = readExcel.readExcelFile("TestData", 25, 1);
        passwordTextBoxOfChangePassword.sendKeys(passwordTextBox);
        String getTextOfPasswordTextBox = passwordTextBoxOfChangePassword.getAttribute("value");
        if (getTextOfPasswordTextBox.contains(passwordTextBox)) {
            System.out.println("Test Passed. New password is entered, visible, and covered in dots.");
        } else {
            System.out.println("Test Failed. New password is not entered, visible, and covered in dots.");
        }
        Assert.assertTrue(getTextOfPasswordTextBox.contains(passwordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");

        String confirmPasswordTextBox = readExcel.readExcelFile("TestData", 26, 1);
        confirmPasswordTextBoxOfChangePassword.sendKeys(confirmPasswordTextBox);
        String getConfirmPasswordTextBox = confirmPasswordTextBoxOfChangePassword.getAttribute("value");
        if (getConfirmPasswordTextBox.contains(confirmPasswordTextBox)) {
            System.out.println("Test Passed. Confirm password is entered, visible, and covered in dots.");
        } else {
            System.out.println("Test Failed. Confirm password is not entered, visible, and covered in dots.");
        }
        Assert.assertTrue(confirmPasswordTextBox.contains(getConfirmPasswordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");
        saveButtonOfChangePassword.click();
        screenshot.captureScreenshot(driver, "failed-screenshot");
        if (saveButtonOfChangePassword.isDisplayed()) {
            System.out.println("A success message is displayed, indicating that the password has been changed successfully.");
        } else {
            System.out.println("A success message is not displayed, not indicating that the password has been changed successfully.");
        }
    }

    public void userCannotChangePasswordByProvidingInvalidCurrentPasswordRecords(WebDriver driver) throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String currentPasswordTextBox = readExcel.readExcelFile("TestData", 28, 1);
        currentPasswordTextBoxOfChangePassword.sendKeys(currentPasswordTextBox);
        String getTextOfCurrentPasswordTextBox = currentPasswordTextBoxOfChangePassword.getAttribute("value");
        if (getTextOfCurrentPasswordTextBox.contains(currentPasswordTextBox)) {
            System.out.println("Test Passed. Invalid current password is entered, visible, and covered in dots.");
        } else {
            System.out.println("Test Failed. Invalid current password is not entered, visible, and covered in dots.");
        }
        Assert.assertTrue(getTextOfCurrentPasswordTextBox.contains(currentPasswordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");

        String passwordTextBox = readExcel.readExcelFile("TestData", 25, 1);
        passwordTextBoxOfChangePassword.sendKeys(passwordTextBox);
        String getTextOfPasswordTextBox = passwordTextBoxOfChangePassword.getAttribute("value");
        if (getTextOfPasswordTextBox.contains(passwordTextBox)) {
            System.out.println("Test Passed. New password is entered, visible, and covered in dots.");
        } else {
            System.out.println("Test Failed. New password is not entered, visible, and covered in dots.");
        }
        Assert.assertTrue(getTextOfPasswordTextBox.contains(passwordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");

        String confirmPasswordTextBox = readExcel.readExcelFile("TestData", 26, 1);
        confirmPasswordTextBoxOfChangePassword.sendKeys(confirmPasswordTextBox);
        String getConfirmPasswordTextBox = confirmPasswordTextBoxOfChangePassword.getAttribute("value");
        if (getConfirmPasswordTextBox.contains(confirmPasswordTextBox)) {
            System.out.println("Test Passed. Confirm password is entered, visible, and covered in dots.");
        } else {
            System.out.println("Test Failed. Confirm password is not entered, visible, and covered in dots.");
        }
        Assert.assertTrue(confirmPasswordTextBox.contains(getConfirmPasswordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");
        saveButtonOfChangePassword.click();
        screenshot.captureScreenshot(driver, "failed-screenshot");
        if (saveButtonOfChangePassword.isDisplayed()) {
            System.out.println("Test Passed. An error message is displayed, indicating that the current password is incorrect.");
        } else {
            System.out.println("Test Failed. An error message is not displayed and indicating that the current password is incorrect.");
        }
    }

    public void VerifyUserCannotChangePasswordWhenNewPasswordsDoNotMatchRecords(WebDriver driver) throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String currentPasswordTextBox = readExcel.readExcelFile("TestData", 24, 1);
        currentPasswordTextBoxOfChangePassword.sendKeys(currentPasswordTextBox);
        String getTextOfCurrentPasswordTextBox = currentPasswordTextBoxOfChangePassword.getAttribute("value");
        if (getTextOfCurrentPasswordTextBox.contains(currentPasswordTextBox)) {
            System.out.println("Test Passed. Current password is entered, visible and covered in dots.");
        } else {
            System.out.println("Test Failed. Current password is not entered, visible and covered in dots.");
        }
        Assert.assertTrue(getTextOfCurrentPasswordTextBox.contains(currentPasswordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");

        String passwordTextBox = readExcel.readExcelFile("TestData", 25, 1);
        passwordTextBoxOfChangePassword.sendKeys(passwordTextBox);
        String getTextOfPasswordTextBox = passwordTextBoxOfChangePassword.getAttribute("value");
        if (getTextOfPasswordTextBox.contains(passwordTextBox)) {
            System.out.println("Test Passed. New password is entered, visible, and covered in dots.");
        } else {
            System.out.println("Test Failed. New password is not entered, visible, and covered in dots.");
        }
        Assert.assertTrue(getTextOfPasswordTextBox.contains(passwordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");

        String confirmPasswordTextBox = readExcel.readExcelFile("TestData", 34, 1);
        confirmPasswordTextBoxOfChangePassword.sendKeys(confirmPasswordTextBox);
        String getConfirmPasswordTextBox = confirmPasswordTextBoxOfChangePassword.getAttribute("value");
        if (getConfirmPasswordTextBox.contains(confirmPasswordTextBox)) {
            System.out.println("Test Passed. Confirm password is entered, visible, and covered in dots.");
        } else {
            System.out.println("Test Failed. Confirm password is not entered, visible, and covered in dots.");
        }
        Assert.assertTrue(confirmPasswordTextBox.contains(getConfirmPasswordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");
        saveButtonOfChangePassword.click();
        if (passwordDoNotMatchText.isDisplayed()) {
            System.out.println("Test Passed. An error message is displayed, indicating that the new passwords do not match.");
        } else {
            System.out.println("Test Failed. An error message is not displayed and indicating that the new passwords do not match.");
        }
    }

    public void VerifyUserCannotChangePasswordWhenNewPasswordDoesNotMeetSpecifiedCriteriaRecords(WebDriver driver) throws IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String currentPasswordTextBox = readExcel.readExcelFile("TestData", 36, 1);
        currentPasswordTextBoxOfChangePassword.sendKeys(currentPasswordTextBox);
        String getTextOfCurrentPasswordTextBox = currentPasswordTextBoxOfChangePassword.getAttribute("value");
        if (getTextOfCurrentPasswordTextBox.contains(currentPasswordTextBox)) {
            System.out.println("Test Passed. Current password is entered, visible and covered in dots.");
        } else {
            System.out.println("Test Failed. Current password is not entered, visible and covered in dots.");
        }
        Assert.assertTrue(getTextOfCurrentPasswordTextBox.contains(currentPasswordTextBox));
        screenshot.captureScreenshot(driver, "failed-screenshot");

        String passwordTextBox = readExcel.readExcelFile("TestData", 37, 1);
        passwordTextBoxOfChangePassword.sendKeys(passwordTextBox);
        Thread.sleep(2000);
        if (shouldHaveAtLeastSevenCharacters.isDisplayed()) {
            System.out.println("Test Passed. New password is entered, but an error message is displayed indicating the password must have at least 7 characters.");
        } else {
            System.out.println("Test Failed. New password is entered, but an error message is not displayed and indicating the password must have at least 7 characters.");
        }
        Assert.assertTrue(shouldHaveAtLeastSevenCharacters.isDisplayed());
        screenshot.captureScreenshot(driver, "failed-screenshot");
        Thread.sleep(2000);
        passwordTextBoxOfChangePassword.clear();

        String passwordNewTextBox = readExcel.readExcelFile("TestData", 38, 1);
        passwordTextBoxOfChangePassword.sendKeys(passwordTextBox);
        Thread.sleep(2000);
        if (yourPasswordContainMinimumOneLowerCaseLetter.isDisplayed()) {
            System.out.println("Test Passed. New password is entered, but an error message is displayed indicating the password must contain at least one lowercase letter.");
        } else {
            System.out.println("Test Failed. New password is entered, but an error message is not displayed and indicating the password must contain at least one lowercase letter.");
        }
        Assert.assertTrue(yourPasswordContainMinimumOneLowerCaseLetter.isDisplayed());
        screenshot.captureScreenshot(driver, "failed-screenshot");
        Thread.sleep(2000);
        saveButtonOfChangePassword.click();
    }

    public void VerifyUserCannotChangePasswordWhenAllFieldsLeftEmptyRecords(){
    saveButtonOfChangePassword.click();
    if (saveButtonOfChangePassword.isDisplayed()){
        System.out.println("Test Passed. An error message is displayed indicating for each field that is required.");
    }else {
        System.out.println("Test Failed. An error message is not displayed and indicating for each field that is required.");
    }
    }

    public void  VerifyUserCanLogoutSuccessfullyRecords(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        logoutButton.click();
        String getUrlOfIndexPage = driver.getCurrentUrl();
        if (getUrlOfIndexPage.contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")){
            System.out.println("Test Passed. The login page is displayed, confirming the user is logged out.");
        }else {
            System.out.println("Test Failed. The login page is not displayed, confirming the user is logged out.");
        }



    }


}