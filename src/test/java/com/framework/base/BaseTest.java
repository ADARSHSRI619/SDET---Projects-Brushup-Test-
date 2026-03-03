package com.framework.base;

import com.framework.config.ConfigReader;
import com.framework.driver.DriverFactory;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initDriver();
        LOGGER.info("Browser started. Target environment: {}", ConfigReader.get("environment"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            saveFailureScreenshot();
        }
        DriverFactory.quitDriver();
        LOGGER.info("Browser closed for test: {}", result.getName());
    }

    @Attachment(value = "Failure screenshot", type = "image/png")
    private byte[] saveFailureScreenshot() {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
