package com.OrangeHrmAutomation.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentListenerClass implements ITestListener {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReports(){
        htmlReporter = new ExtentSparkReporter("ExtentReporter.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        reports.setSystemInfo("Machine Name :","PC-1");
        reports.setSystemInfo("Browser :","Chrome");
        reports.setSystemInfo("Operating System :","Windows 11");
        reports.setSystemInfo("Environment :","QA");
        reports.setSystemInfo("QA Name :","Shrikant");

        htmlReporter.config().setDocumentTitle("OrangeHrm Automation Reports");
        htmlReporter.config().setReportName("Functional Testing");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setTimeStampFormat("dd-MM-yyyy, HH:mm:ssm, a");
    }

    public void onStart(ITestContext Result){
        configureReports();
    }

    public void onFinish(ITestContext Result){
        reports.flush();
    }

    public void onTestStart(ITestResult Result){
        System.out.println("Name of the Test case start is : "+Result.getName());
    }

    public void onTestSuccess(ITestResult Result){
        System.out.println("Name of the successfully executed test is : "+Result.getName());
        test=reports.createTest(Result.getName());
        test.log(Status.PASS,MarkupHelper.createLabel("Name of passed test case is : "+Result.getName(),ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult Result){
        System.out.println("Name of the failed Test is : "+Result.getName());
        test = reports.createTest(Result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is : "+Result.getName(), ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir")+"//screenshots//"+Result.getName()+".png";
        File screenshotFile = new File(screenShotPath);
        if (screenshotFile.exists()){
            test.fail("Captured screenshot is below"+ test.addScreenCaptureFromPath(screenShotPath));
        }
    }

    public void onTestSkipped(ITestResult Result){
        System.out.println("Name of the skipped Test is : "+Result.getName());
        test=reports.createTest(Result.getName());
        test.log(Status.SKIP,MarkupHelper.createLabel("Name of the skipped test case is : "+Result.getName(),ExtentColor.YELLOW));
    }
}