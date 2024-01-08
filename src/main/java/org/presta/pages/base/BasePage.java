package org.presta.pages.base;

import com.microsoft.playwright.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Slf4j
public class BasePage {

    public Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public String getPageTitle() {
        return page.title();
    }

    public void inputText(Locator element, String text) {
        element.fill(text);
    }

    public ElementHandle getRandomElement(List<ElementHandle> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public BigDecimal getPrice(Locator element) {
        return new BigDecimal(element.innerText().replace("$", ""));
    }

    public void clearAndInputText(Locator element, String text) {
        element.clear();
        if (element.innerText().length() != 0) {
            element.clear();
        } else {
            element.fill(text);
        }
    }
}
