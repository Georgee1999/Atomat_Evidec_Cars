package tests.LandingPageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;

public class UITests extends BaseTest {

    @Test(groups = {"UI"})
    public void visibleTextOfElements() {
        Assert.assertEquals(landingPage.getTextOfLoginButton(),"Přihlásit se");
        Assert.assertEquals(landingPage.getTextOfRegisterButton(),"Registrovat");
        Assert.assertEquals(landingPage.getTextOfIconButton(),"Evidence Aut");
    }
    @Test(groups = {"UI"})
    public void areElementsEnabled(){
        Assert.assertTrue(landingPage.isEnable());
    }

    @Test(groups = {"UI"})
    public void isAppearLoginModal(){
        Assert.assertTrue(landingPage.appearLoginModal());
    }
    @Test(groups = {"UI"})
    public void isAppearRegisterModal(){
        Assert.assertTrue(landingPage.appearRegisterModal());
    }



}
