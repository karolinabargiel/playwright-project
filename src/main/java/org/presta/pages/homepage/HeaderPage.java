package org.presta.pages.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

public class HeaderPage extends BasePage {

    private final Locator contactUsBtn = page.locator("#contact-link");
    private final Locator signInBtn = page.getByTitle("Log in to your customer account");
    private final Locator searchInput = page.locator("input[placeholder='Search our catalog']");
    private final Locator searchBtn = page.locator("button[type='submit']");

    public HeaderPage(Page page) {
        super(page);
    }

    public void clickOnContactUs() {
        contactUsBtn.click();
    }

    public SignInPage clickOnSignIn() {
        signInBtn.click();
        return new SignInPage(page);
    }

    public void searchForProduct(String text) {
        searchInput.click();
        searchInput.fill(text);
        searchBtn.click();
    }
}
