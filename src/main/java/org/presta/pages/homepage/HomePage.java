package org.presta.pages.homepage;

import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

public class HomePage extends BasePage {


    public HomePage(Page page) {
        super(page);
    }

    public String getPageTitle() {
        return page.title();
    }
}
