package org.presta.pages.homepage;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

import java.util.List;
import java.util.stream.Stream;

public class FooterPage extends BasePage {

    private final Locator productsSubMenu = page.locator("a[id*='link-product-page']");
    private final Locator ourCompanySubMenu = page.locator("a[id*='link-cms-page']");
    private final Locator ourCompanySubMenu2 = page.locator("a[id*='link-static-page']");
    private final Locator yourAccountSubmenu = page.locator("#block_myaccount_infos > ul >li > a");
    private final Locator storeInfoSubmenu = page.locator(".block-contact.col-md-3.links.wrapper");

    public FooterPage(Page page) {
        super(page);
    }

    public List<String> getItemsFromProductsSubMenu() {
        return productsSubMenu.allInnerTexts();
    }

    public List<String> getItemsFromOurCompanySubMenu() {
        List<String> ourCompanyContent1 = ourCompanySubMenu.allInnerTexts();
        List<String> ourCompanyContent2 = ourCompanySubMenu2.allInnerTexts();
        return Stream.concat(ourCompanyContent1.stream(), ourCompanyContent2.stream()).toList();
    }

    public List<String> getItemsFromYourAccountSubMenu() {
        return yourAccountSubmenu.allInnerTexts();
    }

    public List<String> getItemsFromStoreInfoSubMenu() {
        return storeInfoSubmenu.allInnerTexts();
    }
}
