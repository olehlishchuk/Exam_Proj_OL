package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage  extends ParentPage{

    @FindBy(id = "js-header-groups")
    WebElement product;

    public ProductPage(WebDriver webDriver) {
        super(webDriver, "/apples-bgg1056084");
    }

    public boolean isProductDisplayed() {
        return actionsWithOurElements.isElementDisplayed(product);
    }
}
