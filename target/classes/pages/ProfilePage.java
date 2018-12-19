package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends ParentPage {
    EditHomePage editHomePage;
    @FindBy(name = "edt_fio")
    private  WebElement fullNameInput;

    @FindBy(id = "btn-submit")
    private WebElement buttonSave;


    public ProfilePage(WebDriver webDriver) {
        super(webDriver, "/account/edit");
        editHomePage = new EditHomePage(webDriver);
    }

    public void clickButtonSave() {
        actionsWithOurElements.clickOnElement(buttonSave);
    }

}
