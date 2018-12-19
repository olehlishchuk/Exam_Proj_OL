package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditHomePage extends ParentPage {

    @FindBy(name = "edt_fio")
    private WebElement fullNameInput;

    @FindBy(id = "lang")
    private WebElement languageNameInDD;

    @FindBy(id = "btn-submit")
    private WebElement buttonSave;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/nav/section[1]/ul/li[2]/a")
    private WebElement passwordReset;

    @FindBy(id = "old_password")
    private WebElement inputOldPassword;

    @FindBy(id = "new_password")
    private WebElement inputNewPassword;

    @FindBy(id = "new_password_confirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"btn-preview\"]")
    private WebElement buttonPreview;


    public EditHomePage (WebDriver webDriver) { super (webDriver, "/account/edit"); }

    public void clickEditHomePage() {
        try {
            webDriver.get("https://profile.all.biz");
            logger.info("Edit Profile page was opened");
        }catch (Exception e) {
            logger.error("Cannot find edit profile page");
            Assert.fail("Cannot find edit profile page");
        }
    }


    public void enterFullNameInToInput(String fullName) {
        actionsWithOurElements.enterTextInToElement(fullNameInput, fullName);
    }

    public void selectLanguageNameInDD(String languageName) {
        actionsWithOurElements.selectTextInDD(languageNameInDD, languageName);
    }

    public void clickButtonSave() {
        actionsWithOurElements.clickOnElement(buttonSave);
    }



}
