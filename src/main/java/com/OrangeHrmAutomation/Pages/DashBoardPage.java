package com.OrangeHrmAutomation.Pages;

import com.OrangeHrmAutomation.Utilities.ActionsOperation;
import com.OrangeHrmAutomation.Utilities.ReadExcel;
import com.OrangeHrmAutomation.Utilities.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;


public class DashBoardPage {

    ReadExcel readExcel;
    WebDriver driver;
    Waits waits;
    ActionsOperation actionsOperation;


    public DashBoardPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        readExcel = new ReadExcel();
        waits = new Waits();
        actionsOperation = new ActionsOperation();

    }

    @FindBy(xpath = "(//*[text()='Dashboard'])[2]")
    private WebElement dashBoardText;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    private WebElement userDropDown;

    @FindBy(xpath = "//a[text()='Change Password']")
    private WebElement changePasswordButton;

    @FindBy(xpath = "//*[text()='Logout']")
    private WebElement logoutButton;


    public void UserSuccessfullyLoginRedirectedToDashBoardPage() throws IOException, InterruptedException {
        Thread.sleep(2000);
        String actualDashBoardText= dashBoardText.getText();
        String expectedDashBoardText= readExcel.readExcelFile("TestData",5,1);

     if (actualDashBoardText.equals(expectedDashBoardText)){
         System.out.println("Test Passed. The user is successfully logged in and is redirected to the dashboard.");
     }else {
         System.out.println("Test Failed. The user log in is Failed.");
     }
        Assert.assertEquals(expectedDashBoardText,actualDashBoardText);
    }


    public void clickOnTheUserDropDownPlusChangePasswordButton(WebDriver driver) throws InterruptedException {
        userDropDown.click();
        Assert.assertTrue(userDropDown.isDisplayed());
        if (userDropDown.isDisplayed()){
            System.out.println("Test Passed. The dropdown menu is displayed.");
        }else {
            System.out.println("Test Failed. The dropdown menu is not displayed.");
        }
        changePasswordButton.click();
    }

    public void ClickOnOnlyUserDropDown(){
        userDropDown.click();
        Assert.assertTrue(userDropDown.isDisplayed());
        if (userDropDown.isDisplayed()){
            System.out.println("Test Passed. The dropdown menu is displayed.");
        }else {
            System.out.println("Test Failed. The dropdown menu is not displayed.");
        }
    }

    public void ClickOnLogoutButton(WebDriver driver){
        logoutButton.click();
       String getCurrentURL =  driver.getCurrentUrl();
       if (getCurrentURL.contains("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")){
           System.out.println("Test Passed. The login page is displayed, confirming the user is logged out.");
       }else {
           System.out.println("Test Failed. The login page is not displayed and confirming the user is logged out.");
       }
    }



}
