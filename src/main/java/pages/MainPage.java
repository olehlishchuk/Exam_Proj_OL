package pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends ParentPage {
    @FindBy(id = "top_search_input")
    WebElement inputSearch;

    @FindBy(id = "b-search-form")
    WebElement buttonSearch;

    public MainPage(WebDriver webDriver) {
        super (webDriver, "/buy") ;
    }

    public void openMainPage() {
        try {
            webDriver.get("https://all.biz");
            logger.info("Main page was opened");
        }catch (Exception e) {
            logger.error("Cannot open Main page");

            Assert.fail("Cannot open Main page");
        }
    }
    public void inputInSearch( String search) {
        actionsWithOurElements.enterTextInToElement(inputSearch, search);
    }

    public void clickButtonSearch() {
        try {
            buttonSearch.click();
            logger.info("was clicked");
        }catch (Exception e) {
            logger.error("Cannot find such a button");
            Assert.fail("Cannot find such a button");
        }
    }
    public boolean isbuttonSearchDisplayed() {
        return actionsWithOurElements.isElementDisplayed(buttonSearch);
    }

    public void enterTextInToSearch(String search) {
        openMainPage();
        enterTextInToSearch(search);
        clickButtonSearch();
    }

    public void InputProductInToSearch() {
        enterTextInToSearch("apples");
        HomePage homePage = new HomePage(webDriver);
        homePage.isProductDisplayed();
    }
}
