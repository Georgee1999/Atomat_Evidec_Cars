package tests.UserDashboardTests;

import org.example.pagesObjects.UserDashboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.util.HashMap;

public class UITests extends BaseTest {

    @Test(dataProvider = "getUserData",groups = {"UI"})
    public void areElementsEnabled(HashMap<String, String> input){
        UserDashboard userDashboard = landingPage.loginApplication(input.get("email"));
        Assert.assertTrue(userDashboard.isEnable());
    }
    @Test(dataProvider = "getUserData", groups = {"UI"})
    public void visibleTextOfElements(HashMap<String, String> input) {
        UserDashboard userDashboard = landingPage.loginApplication(input.get("email"));
        Assert.assertEquals(userDashboard.getTextOfLogOutButton(),"Odhlásit se");
        Assert.assertEquals(userDashboard.getTextOfFindCarsButton(),"Vyhledat auta");
        Assert.assertEquals(userDashboard.getTextOfAllCarsButton(),"Registrovaná auta");
        Assert.assertEquals(userDashboard.getTextOfDeleteCarButton(),"Smazat auto");
        Assert.assertEquals(userDashboard.getTextOfNewCarButton(),"Nové auto");
        Assert.assertEquals(userDashboard.getTextOfIconButton(),"Evidence Aut");
    }


}
