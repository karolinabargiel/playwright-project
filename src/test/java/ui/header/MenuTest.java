package ui.header;

import base.Pages;
import dataProvider.DataProviderUi;
import org.presta.enums.MenuOptions;
import org.testng.annotations.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest extends Pages {

    @Test (dataProvider = "mainMenuTest", dataProviderClass = DataProviderUi.class)
    public void shouldCheckMenuOptions(Map<MenuOptions, String> testData) {
        for (MenuOptions option : MenuOptions.values()){
            headerPage.clickOnMenuBtn(option);
            assertThat(page.title()).isEqualTo(testData.get(option));
        }
    }
}
