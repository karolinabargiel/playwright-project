package org.presta.pages.account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.presta.pages.base.BasePage;

import java.util.List;

public class OrderHistoryPage extends BasePage {

    private final Locator orders = page.locator(".order");

    public OrderHistoryPage(Page page) {
        super(page);
    }

    public List<String> getListOfOrders() {
        return orders.allTextContents();
    }
}
