package ui.account;

import base.Pages;
import dataProvider.DataProviderUi;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class RegisterNewUserTest extends Pages {

    @Test (dataProvider = "registerTest", dataProviderClass = DataProviderUi.class)
    public void shouldRegisterNewUser(String pageTitle) {
        headerPage.clickOnSignIn()
                .clickRegisterNewUser()
                .fillRegisterForm()
                .tickMandatoryCheckboxes()
                .clickSaveButton();
        Assertions.assertThat(page.title())
                .as("New user should be redirected to homepage").isEqualTo(pageTitle);
    }
}
