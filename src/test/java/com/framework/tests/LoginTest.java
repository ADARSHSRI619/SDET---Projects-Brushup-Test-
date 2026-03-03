package com.framework.tests;

import com.framework.config.ConfigReader;
import com.framework.base.BaseTest;
import com.framework.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Login")
public class LoginTest extends BaseTest {

    @Test(description = "Validate successful login with standard user")
    @Story("User can log in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldLoginSuccessfully() {
        LoginPage loginPage = new LoginPage()
                .open(ConfigReader.get("app.base.url"))
                .login(ConfigReader.get("app.username"), ConfigReader.get("app.password"));

        String message = loginPage.flashMessage();
        Assert.assertTrue(message.contains("You logged into a secure area!"), "Login success message is incorrect.");
    }
}
