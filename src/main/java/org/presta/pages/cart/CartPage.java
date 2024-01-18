package org.presta.pages.cart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;
import org.presta.pages.checkout.AddressesPage;

import java.math.BigDecimal;

public class CartPage extends BasePage {

    private final Locator proceedToCheckoutBtn = page.getByText("Proceed to checkout");
    private final Locator emptyCartLabel = page.locator(".js-cart > .no-items");
    private final Locator totalPrice = page.locator("div[class='cart-summary-line cart-total'] span[class='value']");

    public CartPage(Page page) {
        super(page);
    }

    public AddressesPage clickProceedToCheckoutInCart() {
        proceedToCheckoutBtn.click();
        return new AddressesPage(page);
    }

    public String getEmptyCartLabel() {
        return emptyCartLabel.innerText();
    }

    public BigDecimal getTotalPrice() {
        return getPrice(totalPrice);
    }
}
