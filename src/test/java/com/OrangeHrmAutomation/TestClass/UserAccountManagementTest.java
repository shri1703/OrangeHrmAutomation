package com.OrangeHrmAutomation.TestClass;

import com.OrangeHrmAutomation.BaseClass.BasePage;
import com.OrangeHrmAutomation.Pages.DashBoardPage;
import com.OrangeHrmAutomation.Pages.IndexMainPage;
import com.OrangeHrmAutomation.Pages.UpdatePasswordPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserAccountManagementTest extends BasePage {

   @Test(enabled = false)
    public void VerifyUserCanChangePasswordWithValidCredentialsTest() throws IOException, InterruptedException {
    driver.get(url);
    IndexMainPage indexMainPage = new IndexMainPage(driver);
    indexMainPage.VerifyAdminLoginWithValidCredentials(driver);
    DashBoardPage dashBoardPage = new DashBoardPage(driver);
    dashBoardPage.UserSuccessfullyLoginRedirectedToDashBoardPage();
    dashBoardPage.clickOnTheUserDropDownPlusChangePasswordButton(driver);
    UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
    updatePasswordPage.VerifyChangePasswordVisible(driver);
    updatePasswordPage.userCanChangePasswordWithValidCredentialsRecords(driver);
    }

    @Test(enabled = false)
    public void userCannotChangePasswordByProvidingInvalidCurrentPasswordTest() throws IOException, InterruptedException {
     driver.get(url);
     IndexMainPage indexMainPage = new IndexMainPage(driver);
     indexMainPage.VerifyAdminLoginWithValidCredentials(driver);
     DashBoardPage dashBoardPage = new DashBoardPage(driver);
     dashBoardPage.UserSuccessfullyLoginRedirectedToDashBoardPage();
     dashBoardPage.clickOnTheUserDropDownPlusChangePasswordButton(driver);
     UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
     updatePasswordPage.VerifyChangePasswordVisible(driver);
     updatePasswordPage.userCannotChangePasswordByProvidingInvalidCurrentPasswordRecords(driver);
    }

    @Test(enabled = false)
    public void VerifyUserCannotChangePasswordWhenNewPasswordsDoNotMatchTest() throws IOException, InterruptedException {
    driver.get(url);
    IndexMainPage indexMainPage = new IndexMainPage(driver);
     indexMainPage.VerifyAdminLoginWithValidCredentials(driver);
     DashBoardPage dashBoardPage = new DashBoardPage(driver);
     dashBoardPage.UserSuccessfullyLoginRedirectedToDashBoardPage();
     dashBoardPage.clickOnTheUserDropDownPlusChangePasswordButton(driver);
     UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
     updatePasswordPage.VerifyChangePasswordVisible(driver);
     updatePasswordPage.VerifyUserCannotChangePasswordWhenNewPasswordsDoNotMatchRecords(driver);
    }

    @Test(priority =3)
    public void VerifyUserCannotChangePasswordWhenNewPasswordDoesNotMeetSpecifiedCriteriaTest() throws IOException, InterruptedException {
     driver.get(url);
     IndexMainPage indexMainPage = new IndexMainPage(driver);
     indexMainPage.VerifyAdminLoginWithValidCredentials(driver);
     DashBoardPage dashBoardPage = new DashBoardPage(driver);
     dashBoardPage.UserSuccessfullyLoginRedirectedToDashBoardPage();
     dashBoardPage.clickOnTheUserDropDownPlusChangePasswordButton(driver);
     UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
     updatePasswordPage.VerifyChangePasswordVisible(driver);
     updatePasswordPage.VerifyUserCannotChangePasswordWhenNewPasswordDoesNotMeetSpecifiedCriteriaRecords(driver);
    }

    @Test(priority = 2)
    public void VerifyUserCannotChangePasswordWhenAllFieldsLeftEmptyTest() throws IOException, InterruptedException {
    driver.get(url);
    IndexMainPage indexMainPage = new IndexMainPage(driver);
     indexMainPage.VerifyAdminLoginWithValidCredentials(driver);
     DashBoardPage dashBoardPage = new DashBoardPage(driver);
     dashBoardPage.UserSuccessfullyLoginRedirectedToDashBoardPage();
     dashBoardPage.clickOnTheUserDropDownPlusChangePasswordButton(driver);
     UpdatePasswordPage updatePasswordPage = new UpdatePasswordPage(driver);
     updatePasswordPage.VerifyChangePasswordVisible(driver);
     updatePasswordPage.VerifyUserCannotChangePasswordWhenAllFieldsLeftEmptyRecords();
    }

    @Test(priority = 1)
    public void VerifyUserCanLogoutSuccessfullyTest() throws IOException, InterruptedException {
     driver.get(url);
     IndexMainPage indexMainPage = new IndexMainPage(driver);
     indexMainPage.VerifyAdminLoginWithValidCredentials(driver);
     DashBoardPage dashBoardPage = new DashBoardPage(driver);
     dashBoardPage.UserSuccessfullyLoginRedirectedToDashBoardPage();
     dashBoardPage.ClickOnOnlyUserDropDown();
     dashBoardPage.ClickOnLogoutButton(driver);
   }
}
