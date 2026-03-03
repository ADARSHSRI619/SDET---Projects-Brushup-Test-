package com.framework.pages;

import org.openqa.selenium.By;

import java.util.List;

public class DynamicTablePage extends BasePage {
    private final By tableRows = By.cssSelector("table tbody tr");

    public DynamicTablePage open(String baseUrl) {
        driver.get(baseUrl + "/challenging_dom");
        return this;
    }

    public int rowCount() {
        return driver.findElements(tableRows).size();
    }

    public boolean rowContainsText(String expectedText) {
        List<String> rows = driver.findElements(tableRows)
                .stream()
                .map(element -> element.getText().toLowerCase())
                .toList();
        return rows.stream().anyMatch(text -> text.contains(expectedText.toLowerCase()));
    }
}
