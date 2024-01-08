package org.presta.pages.account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.presta.models.User;
import org.presta.models.UserFactory;
import org.presta.pages.base.BasePage;
import org.presta.pages.homepage.HomePage;

@Slf4j
public class CreateAccountPage extends BasePage {

    private final Locator firstNameInput = page.locator("//input[@name='firstname']");
    private final Locator lastNameInput = page.locator("//input[@name='lastname']");
    private final Locator emailInput = page.locator("//input[@name='email']").first();
    private final Locator passwordInput = page.locator("//input[@name='password']");
    private final Locator birthdayInput = page.locator("//input[@name='birthday']");
    private final Locator customerPrivacyCheckbox = page.locator("//input[@name='customer_privacy']");
    private final Locator gdprCheckbox = page.locator("//input[@name='psgdpr']");
    private final Locator saveBtn = page.getByText("Save");

    public CreateAccountPage(Page page) {
        super(page);
    }

    public CreateAccountPage fillRegisterForm() {
        User user = getRandomUser();
        firstNameInput.fill(user.getFirstName());
        lastNameInput.fill(user.getLastName());
        emailInput.fill(user.getEmail());
        passwordInput.fill(user.getPassword());
        birthdayInput.fill(user.getBirthDate());
        log.info("Registered user: " + user);
        return this;
    }

    public CreateAccountPage tickMandatoryCheckboxes() {
        customerPrivacyCheckbox.click();
        gdprCheckbox.click();
        return this;
    }

    public HomePage clickSaveButton() {
        saveBtn.click();
        return new HomePage(page);
    }

    private User getRandomUser() {
        UserFactory userFactory = new UserFactory();
        return userFactory.getRandomUser();
    }
}
