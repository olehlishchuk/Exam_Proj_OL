package search;

import org.junit.Test;
import parentTest.ParentTest;

public class Search extends ParentTest {
    @Test
    public void searchForProduct() {
        mainPage.openMainPage();
        mainPage.inputInSearch("apples");
        mainPage.clickButtonSearch();


        //checkExpectedResult("The product is not displayed", productPage.isProductDisplayed());
    }
}
