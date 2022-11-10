package org.example;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.assertj.core.api.Assertions;
import org.example.constants.EpicConstants;
import org.example.pages.MainPage;
import org.testng.annotations.Test;

public class RegisterUserTest extends BaseTest {

    @Issue("CP-999")
    @Epic(EpicConstants.SOME_EPIC)
    @Feature("Some feature 1")
    @Test
    public void registerUserTest() {
        MainPage mainPage = new MainPage(getWebDriver())
                .open()
                .registerRandomUser();
        Assertions.assertThat(mainPage.isUserLoggedIn()).isFalse();
    }
}
