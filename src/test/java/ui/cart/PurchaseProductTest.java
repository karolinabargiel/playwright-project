package ui.cart;

import base.Pages;
import org.testng.annotations.Test;

public class PurchaseProductTest extends Pages {

    @Test
    public void shouldPurchaseRandomProduct() {
        productsListPage
                .clickOnProductOnPlp()
                .clickAddToCart()
                .clickProceedToCheckout()
                .clickProceedToCheckoutInCart()
                .fillPersonalInfoForm()
                .clickContinueButton();
    }
}
