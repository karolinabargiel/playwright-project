package org.presta.pages.checkout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

public class ShippingMethodPage extends BasePage {

    private final Locator continueBtn = page.locator("button[name='confirmDeliveryOption']");

    public ShippingMethodPage(Page page) {
        super(page);
    }

    public PaymentPage clickContinueBtn() {
        continueBtn.click();
        return new PaymentPage(page);
    }
}
