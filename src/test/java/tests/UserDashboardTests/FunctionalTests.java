package tests.UserDashboardTests;

import org.example.pagesObjects.UserDashboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.util.HashMap;
import java.util.List;

public class FunctionalTests extends BaseTest {


    @Test(dataProvider = "getUserData",groups = {"Functional","FindCars"})
    public void findCars(HashMap<String, String> input){
        UserDashboard userDashboard = landingPage.loginApplication(input.get("email"));
        List<String> displayedEmails = userDashboard.findUsersCar(input.get("email"));
        Assert.assertTrue(displayedEmails.stream().allMatch(email -> email.equals("Email: " + input.get("email"))));
    }

}
