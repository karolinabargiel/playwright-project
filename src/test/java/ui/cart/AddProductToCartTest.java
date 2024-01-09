package ui.cart;

import base.Pages;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddProductToCartTest extends Pages {

    @Test
    public void shouldAddProductToCart() {
        assertThat(productsListPage
                .clickOnProductOnPlp()
                .clickAddToCart()
                .isCartPagePopupVisible())
                .as("Cart page popup is displayed")
                .isTrue();
        assertThat(cartPagePopup.getModalTitle()).contains("Product successfully added to your shopping cart");
    }
}
