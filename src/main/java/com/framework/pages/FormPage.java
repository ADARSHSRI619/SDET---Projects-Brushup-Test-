package com.framework.pages;

import org.openqa.selenium.By;

public class FormPage extends BasePage {
    private final By textInput = By.name("my-text");
    private final By submitButton = By.cssSelector("button");
    private final By successMessage = By.id("message");

    public FormPage open(String formUrl) {
        driver.get(formUrl);
        return this;
    }

    public FormPage submitSimpleForm(String value) {
        type(textInput, value);
        click(submitButton);
        return this;
    }

    public String getSuccessMessage() {
        return text(successMessage);
    }
}
