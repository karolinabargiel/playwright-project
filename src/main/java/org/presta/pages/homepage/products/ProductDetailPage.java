package org.presta.pages.homepage.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;
import org.presta.pages.cart.CartPagePopup;

public class ProductDetailPage extends BasePage {

    private final Locator addToCartBtn = page.locator(".add-to-cart");
    public ProductDetailPage(Page page) {
        super(page);
    }

    public CartPagePopup clickAddToCart() {
        addToCartBtn.click();
        return new CartPagePopup(page);
    }
}
