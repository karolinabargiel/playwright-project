package ui.cart;

import base.Pages;
import dataProvider.DataProviderUi;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseProductTest extends Pages {

    @Test (dataProvider = "purchaseTest", dataProviderClass = DataProviderUi.class)
    public void shouldPurchaseRandomProduct(String pageTitle) {
        headerPage.clickOnSignIn()
                .signIn(config.getUserEmail(), System.getProperty("decrypted.password"))
                .clickHomeBtn()
                .clickOnProductOnPlp()
                .clickAddToCart()
                .clickProceedToCheckout()
                .clickProceedToCheckoutInCart()
                .clickContinueBtn()
                .clickContinueBtn()
                .checkMandatoryOptions()
                .clickPlaceOrder();
        assertThat(orderConfirmationPage.getPageTitle()).isEqualTo(pageTitle);
    }
}
