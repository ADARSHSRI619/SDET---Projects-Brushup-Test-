package com.framework.api.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {
    protected static final Logger LOGGER = LogManager.getLogger(BaseApiTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        LOGGER.info("Starting API test execution...");
    }
}
