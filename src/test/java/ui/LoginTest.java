package ui;

import base.Pages;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class LoginTest extends Pages {

    @Test
    public void shouldLoginUser() {
        Assertions.assertThat(headerPage.clickOnSignIn()
                .signIn(config.getUserEmail(), config.getUserPassword())
                .getTitle())
                .as("Your account page should be displayed")
                .isEqualTo("Your account");
    }
}
