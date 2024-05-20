package tests.UserDashboardTests;

import org.example.pagesObjects.UserDashboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;


import java.util.HashMap;
import java.util.List;

public class FunctionalTests extends BaseTest {


    @Test(dataProvider = "getUserData",groups = {"Functional","FindUserCars"})
    public void findCars(HashMap<String, String> input){
        UserDashboard userDashboard = landingPage.loginApplication(input.get("email"));
        List<String> displayedEmails = userDashboard.findUsersCar(input.get("email"));
        Assert.assertTrue(displayedEmails.stream().allMatch(email -> email.equals("Email: " + input.get("email"))));
    }

    @Test(dataProvider = "getOneUsersData",groups = {"Functional","DeleteCar"})
    public void deleteCar(HashMap<String, String> input) throws InterruptedException {
        UserDashboard userDashboard = landingPage.loginApplication(input.get("email"));
        List<String> displayedSPZ = userDashboard.deleteCar("555 5555");
        Assert.assertFalse(displayedSPZ.stream().anyMatch(spz -> spz.equals("555 5555")));
    }

    @Test(dataProvider = "getRegisterCarsData",groups = {"Functional","RegisterCar"})
    public void registerCar(HashMap<String, String> input) throws InterruptedException {
        UserDashboard userDashboard = landingPage.loginApplication(input.get("email"));
        List<String> displayedSPZ = userDashboard.registerCar(input.get("SPZ"),input.get("model"),
                input.get("yearOfMade"),input.get("color"),input.get("email"));
        Assert.assertTrue(displayedSPZ.stream().anyMatch(spz -> spz.equals("SPZ: "+input.get("SPZ"))));
    }


}
