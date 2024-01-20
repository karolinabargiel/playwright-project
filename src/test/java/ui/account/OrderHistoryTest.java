package ui.account;

import base.Pages;
import org.testng.annotations.Test;

public class OrderHistoryTest extends Pages {

    @Test
    public void shouldCheckOrderHistory() {
        headerPage.clickOnSignIn()
                .signIn(config.getUserEmail(), System.getProperty("decrypted.password"))
                .clickOrderHistory();
    }
}
