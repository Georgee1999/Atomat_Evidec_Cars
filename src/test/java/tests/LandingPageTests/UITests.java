package tests.LandingPageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;

public class UITests extends BaseTest {

    @Test
    public void visibleTextOfElements() {
        Assert.assertEquals(landingPage.getTextOfLoginButton(),"Přihlásit se");

    }
}
