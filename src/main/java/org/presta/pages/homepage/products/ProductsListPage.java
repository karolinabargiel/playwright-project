package org.presta.pages.homepage.products;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

import java.util.List;

public class ProductsListPage extends BasePage {

    private final Locator productsNames = page.locator(".product-title");

    public ProductsListPage(Page page) {
        super(page);
    }

    public List<String> getAllProductsTitles() {
        return productsNames.allInnerTexts();
    }

    public String getFirstProductTitle() {
        return productsNames.first().innerText();
    }

    public ProductDetailPage clickOnProductOnPlp() {
        productsNames.first().click();
        return new ProductDetailPage(page);
    }
}
