package dataProvider;

import org.testng.annotations.DataProvider;

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
}