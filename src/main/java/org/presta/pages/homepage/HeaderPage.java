package org.presta.pages.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

public class HeaderPage extends BasePage {

    private final Locator contactUsBtn = page.locator("#contact-link");

    public HeaderPage(Page page) {
        super(page);
    }

    public void clickOnContactUs() {
        contactUsBtn.click();
    }
}
