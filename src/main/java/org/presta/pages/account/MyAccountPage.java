package org.presta.pages.account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.presta.pages.base.BasePage;
import org.presta.pages.homepage.HomePage;
import org.presta.pages.homepage.products.ProductsListPage;

@Slf4j
public class MyAccountPage extends BasePage {

    private final Locator homeBtn = page.locator("//img[@class='logo img-responsive']");

    public MyAccountPage(Page page) {
        super(page);
    }

    public ProductsListPage clickHomeBtn() {
        homeBtn.click();
        return new ProductsListPage(page);
    }
}
