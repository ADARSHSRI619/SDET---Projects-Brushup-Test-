package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.config.ConfigReader;
import com.framework.pages.FormPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("UI Forms")
@Feature("Form Submission")
public class FormSubmissionTest extends BaseTest {

    @Test(description = "Validate simple form submission flow")
    @Story("User submits a text field successfully")
    @Severity(SeverityLevel.NORMAL)
    public void shouldSubmitSimpleForm() {
        FormPage formPage = new FormPage()
                .open(ConfigReader.get("app.form.url"))
                .submitSimpleForm("SDET Framework Validation");

        Assert.assertEquals(formPage.getSuccessMessage(), "Received!", "Unexpected form submission result.");
    }
}
