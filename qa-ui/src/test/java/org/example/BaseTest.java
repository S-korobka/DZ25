package org.example;

import org.example.browser.WebDriverFactory;
import org.example.constants.TestConstants;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod(description = "Set up the browser")
    public void beforeMethod(ITestContext iTestContext) {
        WebDriver webDriver = new WebDriverFactory().getDriver();
        setWebDriver(webDriver);
        setDriverToContext(iTestContext,webDriver);
    }

    @AfterMethod(description = "quit the WebDriver")
    public void afterMethod(ITestResult result) {
        getWebDriver().quit();
    }

    public WebDriver getWebDriver() {
        return driverThreadLocal.get();
    }

    private void setWebDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public void setDriverToContext(ITestContext iTestContext,WebDriver driver) {
        iTestContext.setAttribute(TestConstants.WEB_DRIVER,driver);
    }
}
