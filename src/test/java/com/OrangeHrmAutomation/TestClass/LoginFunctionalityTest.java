package com.OrangeHrmAutomation.TestClass;

import com.OrangeHrmAutomation.BaseClass.BasePage;
import com.OrangeHrmAutomation.Pages.DashBoardPage;
import com.OrangeHrmAutomation.Pages.IndexMainPage;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginFunctionalityTest extends BasePage {

    @Test(priority = 1,enabled = false)
    public void verifyAdminLoginWithValidCredentialsRecords() throws IOException, InterruptedException {
        driver.get(url);
        IndexMainPage indexMainPage = new IndexMainPage(driver);
        indexMainPage.VerifyAdminLoginWithValidCredentials(driver);
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.UserSuccessfullyLoginRedirectedToDashBoardPage();
    }

    @Test(priority = 2)
    public void VerifyAdminCannotLoginWithInvalidCredentialsRecords() throws IOException, InterruptedException {
    driver.get(url);
    IndexMainPage indexMainPage = new IndexMainPage(driver);
    indexMainPage.VerifyAdminCannotLoginWithInvalidCredentials(driver);
    }

    @Test(priority = 3,enabled = false)
    public void VerifyAdminCannotLoginWithOnlyUsernameFilledRecords() throws IOException {
        driver.get(url);
        IndexMainPage indexMainPage = new IndexMainPage(driver);
        indexMainPage.VerifyAdminCannotLoginWithOnlyUsernameFilled(driver);
    }

    @Test(priority = 4,enabled = false)
    public void VerifyAdminCannotLoginWithOnlyPasswordFilledRecords() throws IOException {
        driver.get(url);
        IndexMainPage indexMainPage = new IndexMainPage(driver);
        indexMainPage.VerifyAdminCannotLoginWithOnlyPasswordFilled(driver);
    }

    @Test(priority = 5,enabled = false)
    public void VerifyAdminCannotLoginWithBothFieldsEmptyRecords() throws IOException {
        driver.get(url);
        IndexMainPage indexMainPage = new IndexMainPage(driver);
        indexMainPage.VerifyAdminCannotLoginWithBothFieldsEmpty(driver);
    }
}
