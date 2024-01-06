package org.presta.pages.account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.presta.pages.base.BasePage;

@Slf4j
public class MyAccountPage extends BasePage {

    private final Locator pageTitle = page.locator(".page-header");
    public MyAccountPage(Page page) {
        super(page);
    }

    public String getTitle() {
        return getPageTitle(pageTitle);
    }
}
