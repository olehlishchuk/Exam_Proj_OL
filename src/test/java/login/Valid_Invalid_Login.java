package login;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class Valid_Invalid_Login extends ParentTest {
    @Test
    public void validLogin() {
        loginPage.openLoginPage();
        loginPage.enterEmail("olehlishchuk@gmail.com");
        loginPage.enterPassword("QALight2013");
        loginPage.clickButtonLogIn();

       checkExpectedResult("Profile is not present", homePage.isMyProfileDisplayed());
    }

    @Test
    public void invalidLogin() {
        loginPage.openLoginPage();
        loginPage.enterEmail("olehlishchuk@gmail.com");
        loginPage.enterPassword("QALight2015");
        loginPage.clickButtonLogIn();

        Assert.assertTrue("Profile is not present", homePage.isMyProfileDisplayed());
    }


}
