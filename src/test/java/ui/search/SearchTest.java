package ui.search;

import base.Pages;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends Pages {

    @Test
    public void shouldSearchForItem() {
        int numberOfProducts = productsListPage.getNumberOfProducts();
        Assertions.assertThat(numberOfProducts).isPositive();
        String randomProductName = productsListPage.getNameOfRandomProduct();
        headerPage.searchForProduct(randomProductName);
        String resultOfSearch = productsListPage.getFirstProductTitle();
        assertThat(resultOfSearch).isEqualTo(randomProductName);
    }
}
