package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.config.ConfigReader;
import com.framework.pages.DynamicTablePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Data Validation")
@Feature("Dynamic Table")
public class DynamicTableTest extends BaseTest {

    @Test(description = "Validate table has expected content and row count")
    @Story("Dynamic table displays valid records")
    @Severity(SeverityLevel.NORMAL)
    public void shouldValidateDynamicTable() {
        DynamicTablePage tablePage = new DynamicTablePage().open(ConfigReader.get("app.base.url"));

        Assert.assertTrue(tablePage.rowCount() >= 1, "Table should have at least one row.");
        Assert.assertTrue(tablePage.rowContainsText("Iuvaret"), "Expected row content was not found.");
    }
}
