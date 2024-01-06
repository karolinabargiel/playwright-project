package base;

import org.presta.pages.account.MyAccountPage;
import org.presta.pages.homepage.HeaderPage;
import org.presta.pages.homepage.SignInPage;
import org.testng.annotations.BeforeMethod;

public class Pages extends TestBase {
    public HeaderPage headerPage;
    public SignInPage signInPage;
    public MyAccountPage myAccountPage;

    @BeforeMethod
    public void initializePages() {
        headerPage = new HeaderPage(page);
        signInPage = new SignInPage(page);
        myAccountPage = new MyAccountPage(page);
    }
}
