package tests.LandingPageTests;

import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.io.IOException;

public class LoginTests extends BaseTest {


    @Test
    public void login() throws IOException {
        landingPage.loginApplication("jirikvarda123@gmail.com");
    }







       // List<WebElement> cars = driver.findElements(By.id("card"));



    //    WebElement car = cars.stream().filter(c ->
    //            c.findElement(By.xpath("//strong[@class='SPZ']")).getText()
    //            .equals("SPZ"))
    //            .findFirst().orElse(null);

}
