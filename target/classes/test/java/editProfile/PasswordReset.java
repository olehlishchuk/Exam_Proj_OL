package editProfile;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class PasswordReset extends ParentTest {
    @Test
    public void reSetPassword() {
        loginPage.validLoginInToApp();
        homePage.clickOnPasswordReset();
        homePage.enterOldPassword("QALight2013");
        homePage.enterNewPassword("1234567890");
        homePage.confirmNewPassword("1234567890");
        homePage.clickButtonPreview();

        checkExpectedResult("Button Login cannot be not displayed", loginPage.isButtonLogInDisplayed());
    }

    @Test
    public void samePasswordResetAttempt() {
        loginPage.validLoginInToApp();
        homePage.clickOnPasswordReset();
        homePage.enterOldPassword("QALight2013");
        homePage.enterNewPassword("QALight2013");
        homePage.confirmNewPassword("QALight2013");
        homePage.clickButtonPreview();

        Assert.assertFalse("Button login cannot be displayed", loginPage.isButtonLogInDisplayed());
    }
}
