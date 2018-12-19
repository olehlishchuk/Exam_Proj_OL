package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = "//*[@id=\"js-b-wrapper\"]/div[1]/div/div/main/aside/section[2]/div/div[1]/a")
    WebElement product;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[1]/div/h2")
    WebElement MyProfile;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[1]/nav/section[1]/ul/li[1]/a")
    private WebElement menuEdit;

    @FindBy(xpath = "//*[@id=\"ProfileForm\"]/div[1]/div[2]/input")
    private WebElement inputFullName;

    @FindBy(xpath = "//*[@id=\"btn-submit\"]")
    private WebElement buttonSave;

    @FindBy(id = "top_search_input")
    private WebElement inputProductName;

    @FindBy(xpath = "//*[@id=\"b-search-form\"]/div[3]/input")
    private WebElement buttonSearch;

    @FindBy(name = "usermail")
    private WebElement buttonLogIn;

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



    public HomePage(WebDriver webDriver) {
        super(webDriver, "/account");
    }


    public boolean isMyProfileDisplayed() {
        return actionsWithOurElements.isElementDisplayed(MyProfile);
    }

    //public void clickOnR


    public void  clickOnMenuEdit() {
        actionsWithOurElements.clickOnElement(menuEdit);
    }

    public void enterFullName(String fullName) {
        actionsWithOurElements.enterTextInToElement(inputFullName, fullName);
    }

    public void clickButtonSave() {
        try {
            buttonSave.click();
            logger.info("was clicked");
        } catch (Exception e) {
            logger.error("Cannot find such a button");
            Assert.fail("Cannot find such a button");
        }
    }

    public boolean isButtonSaveDisplayed() {
        return actionsWithOurElements.isElementDisplayed(buttonSave);
    }

    public void enterOldPassword(String passWordOld) {
        actionsWithOurElements.enterTextInToElement(inputOldPassword, passWordOld);
    }

    public void enterNewPassword(String passWordNew) {
        actionsWithOurElements.enterTextInToElement(inputNewPassword, passWordNew);
    }

    public void confirmNewPassword(String passWordConfirm) {
        actionsWithOurElements.enterTextInToElement(confirmPassword, passWordConfirm);
    }

    public void resetPassword(String passWordOld, String passWordNew, String passWordConfirm) {
        clickOnPasswordReset();
        enterOldPassword(passWordOld);
        enterNewPassword(passWordNew);
        confirmNewPassword(passWordConfirm);
        clickButtonPreview();
    }


    public void clickOnPasswordReset() {
        actionsWithOurElements.clickOnElement(passwordReset);
    }

    public void clickButtonPreview() {
        try {
            buttonPreview.click();
            logger.info("was clicked");
        }catch (Exception e) {
            logger.error("Cannot find this button");
            Assert.fail("Cannot find this button");
        }
    }

    public boolean isButtonPreviewDisplayed() {
        return actionsWithOurElements.isElementDisplayed(buttonPreview);
    }

    public void resetCurrentPassword() {
        resetPassword("QALight2013", "1234567890", "1234567890");
        HomePage homePage = new HomePage(webDriver);
        homePage.isPasswordReseted();
    }

    public void selectLanguageNameInDD(String Deutsch) {
    }

    public boolean isPasswordReseted() {
        return actionsWithOurElements.isElementDisplayed(buttonLogIn);
    }


    public boolean isProductDisplayed() {
        return actionsWithOurElements.isElementDisplayed(product);
    }
}
