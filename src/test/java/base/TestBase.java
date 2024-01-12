package base;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.presta.config.Config;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public void closeContext(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshot(testResult.getMethod().getMethodName());
        }
        context.close();
        log.info("context is closed");
    }

    @AfterSuite
    public void closeBrowser() {
        playwright.close();
        log.info("Playwright is closed");
    }

    private void takeScreenshot(String name) {
        String screenshotPath = "src/main/resources/screenshots/" + name +
                new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".jpg";
        Path path = Paths.get(screenshotPath);
        try {
            page.screenshot(new Page.ScreenshotOptions().setPath(path));
            InputStream is = Files.newInputStream(path);
            Allure.addAttachment("Screenshot", is);
            log.info("Screenshot saved as: " + screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
