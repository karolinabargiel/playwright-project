package org.presta.pages.checkout;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.models.User;
import org.presta.models.UserFactory;
import org.presta.pages.base.BasePage;

public class PersonalInformationPage extends BasePage {

    private final Locator firstNameInput = page.locator("input[name='firstname']");
    private final Locator lastNameInput = page.locator("input[name='lastname']");
    private final Locator emailInput = page.locator("input[name='email']").first();
    private final Locator privacyCheckbox = page.locator("input[name='customer_privacy']");
    private final Locator gdprCheckbox = page.locator("input[name='psgdpr']");
    private final Locator continueBtn = page.locator("button[name='continue']").first();

    public PersonalInformationPage(Page page) {
        super(page);
    }

    public PersonalInformationPage fillPersonalInfoForm() {
        User user = getRegisteredUser();
        firstNameInput.fill(user.getFirstName());
        lastNameInput.fill(user.getLastName());
        emailInput.fill(user.getEmail());
        privacyCheckbox.click();
        gdprCheckbox.click();
        return this;
    }

    private User getRegisteredUser() {
        UserFactory userFactory = new UserFactory();
        return userFactory.getAlreadyRegisteredUser();
    }

    public AddressesPage clickContinueButton() {
        continueBtn.click();
        return new AddressesPage(page);
    }
}
