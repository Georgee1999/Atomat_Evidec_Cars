package tests.LandingPageTests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTests extends BaseTest {


    @Test(dataProvider = "getData", groups = {"SuccessLogin"})
    public void login(HashMap<String, String> input) throws IOException {
        landingPage.loginApplication(input.get("email"));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\data\\LoginData.json");
        return new Object[][]{
                {data.get(0)},
                {data.get(1)}
        };
    }










       // List<WebElement> cars = driver.findElements(By.id("card"));



    //    WebElement car = cars.stream().filter(c ->
    //            c.findElement(By.xpath("//strong[@class='SPZ']")).getText()
    //            .equals("SPZ"))
    //            .findFirst().orElse(null);

}
