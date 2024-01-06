package ui;

import base.Pages;
import dataProvider.DataProviderUi;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends Pages {

    @Test (dataProvider = "loginTest", dataProviderClass = DataProviderUi.class)
    public void shouldLoginUser(String pageTitle) {
        Assertions.assertThat(headerPage.clickOnSignIn()
                .signIn(config.getUserEmail(), config.getUserPassword())
                .getTitle())
                .as("Your account page should be displayed")
                .isEqualTo(pageTitle);
    }
}
