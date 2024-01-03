package org.presta.pages.homepage;

import com.microsoft.playwright.Locator;
import org.presta.pages.base.BasePage;

public class HeaderPage extends BasePage {

    private Locator contactUsBtn = page.getByText("Contact us");

    public HeaderPage() {
        super();
    }

    public void clickOnContactUs() {
        contactUsBtn.click();
    }
}
