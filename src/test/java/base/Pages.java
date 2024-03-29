package base;

import org.presta.pages.account.MyAccountPage;
import org.presta.pages.cart.CartPagePopup;
import org.presta.pages.checkout.OrderConfirmationPage;
import org.presta.pages.homepage.FooterPage;
import org.presta.pages.homepage.HeaderPage;
import org.presta.pages.homepage.SignInPage;
import org.presta.pages.homepage.products.ProductsListPage;
import org.testng.annotations.BeforeMethod;

public class Pages extends TestBase {
    public HeaderPage headerPage;
    public SignInPage signInPage;
    public MyAccountPage myAccountPage;
    public ProductsListPage productsListPage;
    public CartPagePopup cartPagePopup;
    public OrderConfirmationPage orderConfirmationPage;
    public FooterPage footerPage;

    @BeforeMethod
    public void initializePages() {
        headerPage = new HeaderPage(page);
        signInPage = new SignInPage(page);
        myAccountPage = new MyAccountPage(page);
        productsListPage = new ProductsListPage(page);
        cartPagePopup = new CartPagePopup(page);
        orderConfirmationPage = new OrderConfirmationPage(page);
        footerPage = new FooterPage(page);
    }
}
