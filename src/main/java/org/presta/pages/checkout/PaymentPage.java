package org.presta.pages.checkout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

public class PaymentPage extends BasePage {

    private final Locator paymentOptionRadioBtn = page.locator("input[name='payment-option']");
    private final Locator conditionsCheckbox = page.locator("input[name='conditions_to_approve[terms-and-conditions]']");

    public PaymentPage(Page page) {
        super(page);
    }

    public void checkMandatoryOptions() {
        paymentOptionRadioBtn.click();
        conditionsCheckbox.click();
    }
}
