package dataProvider;

import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviderUi {

    @DataProvider(name = "loginTest")
    public static Object[][] loginTest() {
        return new Object [][] {
                {"My account"}
        };
    }

    @DataProvider(name = "incorrectLoginTest")
    public static Object[][] incorrectLoginTest() {
        return new Object [][] {
                {"random@test.com", "12345"}
        };
    }

    @DataProvider(name = "validationLoginTest")
    public static Object[][] validationLoginTest() {
        return new Object [][] {
                {"randomtest.com", "Login"},
                {"random@com", "Login"},
                {"random@.com", "Login"},
                {"randomtest@", "Login"}
        };
    }

    @DataProvider(name = "validationPasswordTest")
    public static Object[][] validationPasswordTest() {
        return new Object [][] {
                {" "},
                {"1"},
                {"#2"},
                {"wex"}
        };
    }

    @DataProvider(name = "registerTest")
    public static Object[][] registerTest() {
        return new Object [][] {
                {"TesterSii"}
        };
    }

    @DataProvider(name = "purchaseTest")
    public static Object[][] purchaseTest() {
        return new Object [][] {
                {"Order confirmation"}
        };
    }

    @DataProvider(name = "footerTest")
    public static Object[][] footerTest() {
        List<String> productsSection = List.of("Prices drop", "New products", "Best sales");
        List<String> ourCompanySection = List.of("Delivery", "Legal Notice", "Terms and conditions of use", "About us",
                "Secure payment", "Contact us", "Sitemap", "Stores");
        List<String> yourAccountSection = List.of("Personal info", "Orders", "Credit slips", "Addresses");
        List<String> storeInfoSection = List.of("""
                STORE INFORMATION

                TesterSii
                United States
                Email us: senior-dev-testing@sii.pl""");
        return new Object [][] {
                {1, productsSection},
                {2, ourCompanySection},
                {3, yourAccountSection},
                {4, storeInfoSection}
        };
    }
}