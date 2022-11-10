package org.example.elements;

import io.qameta.allure.Step;
import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextField extends UIElement {

    private static final Logger LOGGER = LoggerFactory.getLogger(TextField.class);

    public TextField(WebDriver driver,By by) {
        super(driver,by);
    }

    public TextField(WebDriver driver,By by,String labelName) {
        super(driver,by,labelName);
    }

    public String getValue() {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        return getWebElement().getAttribute("value");
    }

    @Step("fill in [{this.labelName}], with Value[{value}]")
    public void setValue(String value) {
        WaitUtils.waitUntilElementIsDisplayed(getWebElement());
        getWebElement().clear();
        getWebElement().sendKeys(value);
        LOGGER.info("Element: [{}] set value: [{}]",labelName,value);
    }
}
