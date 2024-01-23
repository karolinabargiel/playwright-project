package ui.account;

import base.Pages;
import dataProvider.DataProviderUi;
import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends Pages {

    @Test (dataProvider = "loginTest", dataProviderClass = DataProviderUi.class)
    public void shouldLoginUser(String pageTitle) {
        assertThat(headerPage.clickOnSignIn()
                .signIn(config.getUserEmail(), System.getProperty("decrypted.password")).getPageTitle())
                .as("Your account page should be displayed")
                .isEqualTo(pageTitle);
    }

    @Test (dataProvider = "incorrectLoginTest", dataProviderClass = DataProviderUi.class)
    public void shouldNotLoginUser(String email, String password) {
        step("Go to Sign in and provide not register user credentials");
        assertThat(headerPage.clickOnSignIn()
                .signInWithFailure(email, password)
                .isAuthenticationAlertDisplayed()).isTrue();
    }

    @Test (dataProvider = "validationLoginTest", dataProviderClass = DataProviderUi.class)
    public void shouldCheckEmailFieldValidation(String email, String pageTitle) {
        step("Go to Sign in and provide not valid email");
        headerPage.clickOnSignIn()
                .signInWithFailure(email, System.getProperty("decrypted.password"));
        assertThat(signInPage.getPageTitle()).isEqualTo(pageTitle);
    }
}