package editProfile;

import org.junit.Test;
import pages.EditHomePage;
import parentTest.ParentTest;

public class EditProfile  extends ParentTest {
    String fullName = "Oleh L";
    private EditHomePage editHomePage;

    @Test
    public void editProfile() {
        loginPage.validLoginInToApp();
        homePage.clickOnMenuEdit();
        homePage.enterFullName(fullName);
        homePage.clickButtonSave();

    }

    @Test
    public void changeLanguage() {
        loginPage.validLoginInToApp();
        homePage.clickOnMenuEdit();
        homePage.selectLanguageNameInDD("Deutsch");
        homePage.clickButtonSave();
    }
}
