package org.presta.pages.checkout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

public class AddressesPage extends BasePage {

    private final Locator addressInput = page.locator("input[name='address1']");
    private final Locator cityInput = page.locator("input[name='city']");
    private final Locator stateDropdown = page.locator("select[name='id_state']");
    private final Locator postalCodeInput = page.locator("input[name='postcode']");
    private final Locator continueBtn = page.locator("button[name='confirm-addresses']");

    public AddressesPage(Page page) {
        super(page);
    }

    public AddressesPage fillAddress(String text, String postCode) {
        addressInput.fill(text);
        cityInput.fill(text);
        postalCodeInput.fill(postCode);
        return this;
    }

    public AddressesPage chooseState() {
        stateDropdown.click();
        page.getByText("AA").click();
        return this;
    }

    public ShippingMethodPage clickContinueBtn() {
        continueBtn.click();
        return new ShippingMethodPage(page);
    }
}
