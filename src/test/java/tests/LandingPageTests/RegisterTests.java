package tests.LandingPageTests;

import org.example.pagesObjects.UserDashboard;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.util.HashMap;

public class RegisterTests extends BaseTest {

    @Test(dataProvider = "getRegisterUserData",groups = {"SuccessRegister"})
    public void successRegister(HashMap<String, String> input){
        UserDashboard userDashboard = landingPage.register(input.get("email"), input.get("firstName"),input.get("lastName"),input.get("address"));
        Assert.assertEquals(userDashboard.getUrl(),"http://localhost:3000/dashboard");
        Assert.assertTrue(userDashboard.userInitials());
    }
    @Test(dataProvider = "getInvalidRegisterUserData",groups = {"InvalidRegister"})
    public void invalidEmailRegister(HashMap<String, String> input){
        boolean errorMessage = landingPage.invalidEmailRegister(input.get("email"), input.get("firstName"),input.get("lastName"),input.get("address"));
        Assert.assertTrue(errorMessage);
    }


}
