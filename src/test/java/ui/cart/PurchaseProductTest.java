package ui.cart;

import base.Pages;
import dataProvider.DataProviderUi;
import org.testng.annotations.Test;

public class PurchaseProductTest extends Pages {

    @Test (dataProvider = "purchaseTest", dataProviderClass = DataProviderUi.class)
    public void shouldPurchaseRandomProduct(String text, String postCode) {
        productsListPage
                .clickOnProductOnPlp()
                .clickAddToCart()
                .clickProceedToCheckout()
                .clickProceedToCheckoutInCart()
                .fillPersonalInfoForm()
                .clickContinueButton()
                .fillAddress(text, postCode)
                .chooseState()
                .clickContinueBtn();
    }
}
