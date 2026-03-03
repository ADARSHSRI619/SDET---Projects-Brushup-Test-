package com.framework.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");

    public LoginPage open(String baseUrl) {
        driver.get(baseUrl + "/login");
        return this;
    }

    public LoginPage login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return this;
    }

    public String flashMessage() {
        return text(flashMessage);
    }
}
