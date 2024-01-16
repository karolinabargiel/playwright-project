package ui.cart;

import base.Pages;
import dataProvider.DataProviderUi;
import org.testng.annotations.Test;

public class PurchaseProductTest extends Pages {

    @Test
    public void shouldPurchaseRandomProduct() {
        headerPage.clickOnSignIn()
                .signIn(config.getUserEmail(), System.getProperty("decrypted.password"))
                .clickHomeBtn()
                .clickOnProductOnPlp()
                .clickAddToCart()
                .clickProceedToCheckout()
                .clickProceedToCheckoutInCart()
                .clickContinueBtn()
                .clickContinueBtn()
                .checkMandatoryOptions();
    }
}
