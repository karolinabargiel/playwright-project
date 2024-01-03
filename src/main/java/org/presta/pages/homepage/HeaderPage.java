package org.presta.pages.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

public class HeaderPage extends BasePage {

    private Locator contactUsBtn = page.getByText("Contact us");

    public HeaderPage(Page page) {
        super(page);
    }

    public void clickOnContactUs() {
        contactUsBtn.first().click();
    }
}
