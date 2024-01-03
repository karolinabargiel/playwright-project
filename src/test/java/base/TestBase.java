package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.presta.config.Config;
import org.testng.annotations.*;


public class TestBase {

    Config config = new Config();
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeSuite
    public void setUpBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
        context = browser.newContext();
        page = context.newPage();
        page.navigate(config.getApplicationUrl());
    }

    @BeforeMethod
    public void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate(config.getApplicationUrl());
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

    @AfterSuite
    public void closeBrowser() {
        playwright.close();
    }
}
