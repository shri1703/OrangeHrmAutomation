package com.OrangeHrmAutomation.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsOperation {

    public void actions(WebDriver driver, WebElement element){
        Actions ac = new Actions(driver);
        ac.moveToElement(element);
    }
}
