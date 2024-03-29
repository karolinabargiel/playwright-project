package org.presta.pages.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.presta.pages.account.CreateAccountPage;
import org.presta.pages.account.MyAccountPage;
import org.presta.pages.base.BasePage;

@Slf4j
public class SignInPage extends BasePage {

    private final Locator emailInput = page.locator("section input[name='email']");
    private final Locator passwordInput = page.locator("input[name='password']");
    private final Locator signInBtn = page.locator("#submit-login");
    private final Locator loginAlert = page.getByText("Authentication failed.");
    private final Locator registerUserBtn = page.getByText("No account? Create one here");

    public SignInPage(Page page) {
        super(page);
    }

    public MyAccountPage signIn(String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        signInBtn.click();
        log.info("user signin with credentials: " + email + "\n" + password);
        return new MyAccountPage(page);
    }

    public SignInPage signInWithFailure (String email, String password) {
        emailInput.fill(email);
        passwordInput.fill(password);
        signInBtn.click();
        log.info("used credentials: " + email + "\n" + password);
        return this;
    }

    public CreateAccountPage clickRegisterNewUser() {
        registerUserBtn.click();
        return new CreateAccountPage(page);
    }

    public SignInPage fillEmailField(String email) {
        emailInput.fill(email);
        page.keyboard().press("Enter");
        return this;
    }

    public boolean isAuthenticationAlertDisplayed() {
        return loginAlert.isVisible();
    }

    public boolean checkFieldValidation() {
        signInBtn.click();
        return true;
    }
}
