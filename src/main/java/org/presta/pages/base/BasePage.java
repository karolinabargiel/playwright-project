package org.presta.pages.base;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Slf4j
public class BasePage {

    public Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public String getPageTitle(Locator element) {
        return element.innerText();
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

    public void takeScreenshot() {
        try {
            // Wskazuje ścieżkę do pliku, w którym zostanie zapisany zrzut ekranu
            String screenshotPath = "src/main/resources/screenshots/" +
                    new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + "screenshot.jpg";
            Path path = Paths.get(screenshotPath);

            // Zapisuje zrzut ekranu do wskazanego pliku
            page.screenshot(new Page.ScreenshotOptions().setPath(path));
            InputStream is = Files.newInputStream(path);
            Allure.addAttachment("Screenshot", is);
            log.info("Screenshot saved in: " + screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
