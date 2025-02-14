package com.OrangeHrmAutomation.TestClass;

import com.OrangeHrmAutomation.BaseClass.BasePage;
import com.OrangeHrmAutomation.Pages.DashBoardPage;
import com.OrangeHrmAutomation.Pages.IndexMainPage;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginFunctionality extends BasePage {

    @Test
    public void verifyAdminLoginWithValidCredentialsRecords() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
        IndexMainPage indexMainPage = new IndexMainPage(driver);
        indexMainPage.VerifyAdminLoginWithValidCredentials();
        DashBoardPage dashBoardPage = new DashBoardPage(driver);
        dashBoardPage.UserSuccessfullyLoginRedirectedToDashBoardPage();
    }
}
