package ui.account;

import base.Pages;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderHistoryTest extends Pages {

    @Test
    public void shouldCheckOrderHistory() {
        List<String> listOfOrders = headerPage.clickOnSignIn()
                .signIn(config.getUserEmail(), System.getProperty("decrypted.password"))
                .clickOrderHistory()
                .getListOfOrders();
        assertThat(listOfOrders).isNotEmpty();
        assertThat(listOfOrders).contains("AKGBVQJEL");
    }
}
