package com.framework.pages;

import com.framework.driver.DriverFactory;
import com.framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WaitUtils wait;

    protected BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WaitUtils();
    }

    protected void type(By locator, String value) {
        WebElement element = wait.waitForVisible(locator);
        element.clear();
        element.sendKeys(value);
    }

    protected void click(By locator) {
        wait.waitForClickable(locator).click();
    }

    protected String text(By locator) {
        return wait.waitForVisible(locator).getText();
    }
}
