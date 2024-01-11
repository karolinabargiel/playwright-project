package org.presta.pages.cart;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;
import org.presta.pages.checkout.PersonalInformationPage;

public class CartPage extends BasePage {

    private final Locator proceedToCheckoutBtn = page.getByText("Proceed to checkout");

    public CartPage(Page page) {
        super(page);
    }

    public PersonalInformationPage clickProceedToCheckoutInCart() {
        proceedToCheckoutBtn.click();
        return new PersonalInformationPage(page);
    }
}
