package org.presta.pages.cart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

public class CartPagePopup extends BasePage {

    private final Locator productName = page.locator(".product-name");
    private final Locator modalLabel = page.locator("#myModalLabel");

    public CartPagePopup(Page page) {
        super(page);
    }

    public String getProductName() {
        return productName.innerText();
    }

    public boolean isCartPagePopupVisible() {
        page.waitForSelector("#myModalLabel").isVisible();
        return modalLabel.isVisible();
    }

    public String getModalTitle() {
        return modalLabel.innerText();
    }
}
