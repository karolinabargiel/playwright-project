package base;

import com.microsoft.playwright.*;
import lombok.extern.slf4j.Slf4j;
import org.presta.config.Config;
import org.testng.annotations.*;

import java.util.List;

@Slf4j
public class TestBase {

    protected Config config = new Config();
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    public Page page;

    @BeforeSuite
    public void setUpBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setArgs(List.of("--start-maximized")));
    }

    @BeforeMethod
    public void createContextAndPage() {
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
        page.navigate(config.getUrl());
        log.info("Playwright is up and running");
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

    @AfterSuite
    public void closeBrowser() {
        playwright.close();
        log.info("Playwright is closed");
    }
}
