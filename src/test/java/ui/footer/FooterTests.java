package ui.footer;

import base.Pages;
import dataProvider.DataProviderUi;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FooterTests extends Pages {

    @Test (dataProvider = "footerTest", dataProviderClass = DataProviderUi.class)
    public void shouldCheckFooterContent(int caseNum, List<String> listOfSubmenuItems) {
        switch(caseNum){
            case 1 -> assertThat(footerPage.getItemsFromProductsSubMenu()).isEqualTo(listOfSubmenuItems);
            case 2 -> assertThat(footerPage.getItemsFromOurCompanySubMenu()).isEqualTo(listOfSubmenuItems);
            case 3 -> assertThat(footerPage.getItemsFromYourAccountSubMenu()).isEqualTo(listOfSubmenuItems);
            case 4 -> assertThat(footerPage.getItemsFromStoreInfoSubMenu()).isEqualTo(listOfSubmenuItems);
        }
    }
}
