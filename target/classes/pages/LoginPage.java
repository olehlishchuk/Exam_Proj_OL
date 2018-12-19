package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name = "useremail")
    WebElement inputLogin;

    @FindBy(name = "userpasswd")
    WebElement inputPassword;

    @FindBy(xpath = "/html/body/div[4]/div/div[1]/div[1]/div/form/div[3]/input" )
    WebElement buttonLogIn;

    public LoginPage(WebDriver webDriver) { super(webDriver, "/passport/login"); }

    public void openLoginPage() {
        try {
            webDriver.get("https://profile.all.biz");
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open Login Page");
            Assert.fail("Cannot open Login Page");
        }
    }


    public void enterEmail(String login) {
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    public void enterPassword(String passWord) {
        actionsWithOurElements.enterTextInToElement(inputPassword, passWord);
    }

    public void clickButtonLogIn() {
        try {
            buttonLogIn.click();
            logger.info("was clicked");
        } catch (Exception e) {
            logger.error("Cannot find such a button");
            Assert.fail("Cannot find such a button");
        }
    }


    public boolean isButtonLogInDisplayed() {
        return actionsWithOurElements.isElementDisplayed(buttonLogIn);
    }
    public void loginInToApp(String email, String passWord) {
        openLoginPage();
        enterEmail(email);
        enterPassword(passWord);
        clickButtonLogIn();
    }

    public void validLoginInToApp() {
        loginInToApp("olehlishchuk@gmail.com", "QALight2013");
        HomePage homePage = new HomePage(webDriver);
        homePage.isMyProfileDisplayed();
    }

}
