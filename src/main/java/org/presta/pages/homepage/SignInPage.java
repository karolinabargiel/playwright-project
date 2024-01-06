package org.presta.pages.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.presta.pages.account.MyAccountPage;
import org.presta.pages.base.BasePage;

@Slf4j
public class SignInPage extends BasePage {

    private final Locator emailInput = page.locator("section input[name='email']");
    private final Locator passwordInput = page.locator("input[name='password']");
    private final Locator signInBtn = page.locator("#submit-login");

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
}
