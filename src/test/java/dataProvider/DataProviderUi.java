package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderUi {

    @DataProvider(name = "loginTest")
    public static Object[][] loginTest() {
        return new Object [][] {
                {"Your account"}
        };
    }
}
