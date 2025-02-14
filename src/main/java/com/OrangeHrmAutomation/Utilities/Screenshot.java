package com.OrangeHrmAutomation.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public void captureScreenshot(WebDriver driver,String testName) throws IOException {
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"//screenshots//"+testName+".png");
        FileHandler.copy(source,destination);
    }
}
