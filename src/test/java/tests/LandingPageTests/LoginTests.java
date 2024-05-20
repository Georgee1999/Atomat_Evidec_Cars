package tests.LandingPageTests;


import org.example.pagesObjects.UserDashboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;


public class LoginTests extends BaseTest {

//LOGIN
    @Test(dataProvider = "getUserData", groups = {"SuccessLogin"})
    public void successLogin(HashMap<String, String> input) {
        UserDashboard userDashboard = landingPage.loginApplication(input.get("email"));
        Assert.assertEquals(userDashboard.getUrl(),"http://localhost:3000/dashboard");
        Assert.assertTrue(userDashboard.userInitials());
    }
//INVALID LOGIN
    @Test(dataProvider = "getInvalidLoginUserData", groups = {"InvalidLogin"})
    public void invalidEmailLogin(HashMap<String, String> input) throws IOException {
       String errorLoginMessage =  landingPage.invalidEmailLogin(input.get("email"));
       Assert.assertEquals(errorLoginMessage,"Uživatel s tímto e-mailem neexistuje!");
    }












       // List<WebElement> cars = driver.findElements(By.id("card"));



    //    WebElement car = cars.stream().filter(c ->
    //            c.findElement(By.xpath("//strong[@class='SPZ']")).getText()
    //            .equals("SPZ"))
    //            .findFirst().orElse(null);

}
