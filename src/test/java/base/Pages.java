package base;

import org.presta.pages.homepage.HeaderPage;
import org.testng.annotations.BeforeMethod;

public class Pages extends TestBase {
    public HeaderPage headerPage;

    @BeforeMethod
    public void initializePages() {
        headerPage = new HeaderPage(page);
    }
}
