package org.presta.pages.homepage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.presta.enums.MenuOptions;
import org.presta.pages.base.BasePage;
import org.presta.pages.homepage.products.ProductsListPage;

public class HeaderPage extends BasePage {

    private final Locator contactUsBtn = page.locator("#contact-link");
    private final Locator signInBtn = page.getByTitle("Log in to your customer account");
    private final Locator searchInput = page.locator("input[placeholder='Search our catalog']");
    private final Locator searchBtn = page.locator("button[type='submit']");
    private final Locator clothesBtn = page.getByText(" Clothes ");
    private final Locator accessoriesBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Accessories"));
    private final Locator artBtn = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Art"));
    private final Locator myStoreBtn = page.locator("img[alt='TesterSii']");

    public HeaderPage(Page page) {
        super(page);
    }

    public void clickOnContactUs() {
        contactUsBtn.click();
    }

    public void clickOnMyStore() {
        myStoreBtn.click();
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

    public ProductsListPage clickOnMenuBtn(MenuOptions menuOptions) {
        switch(menuOptions) {
            case CLOTHES -> clothesBtn.click();
            case ACCESSORIES -> accessoriesBtn.click();
            case ART -> artBtn.click();
        }
        return new ProductsListPage(page);
    }
}
