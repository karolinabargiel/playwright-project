package ui.account;

import base.Pages;
import dataProvider.DataProviderUi;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class LoginTest extends Pages {

    @Test (dataProvider = "loginTest", dataProviderClass = DataProviderUi.class)
    public void shouldLoginUser(String pageTitle) {
        Assertions.assertThat(headerPage.clickOnSignIn()
                .signIn(config.getUserEmail(), config.getUserPassword()).getPageTitle())
                .as("Your account page should be displayed")
                .isEqualTo(pageTitle);
    }

    @Test (dataProvider = "incorrectLoginTest", dataProviderClass = DataProviderUi.class)
    public void shouldNotLoginUser(String email, String password) {
        step("Go to Sign in and provide not register user credentials");
        Assertions.assertThat(headerPage.clickOnSignIn()
                .signInWithFailure(email, password)
                .isAuthenticationAlertDisplayed()).isTrue();
    }
}
