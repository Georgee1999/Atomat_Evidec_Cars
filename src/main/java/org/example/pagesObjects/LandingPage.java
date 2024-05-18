package org.example.pagesObjects;

import org.example.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;

    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("http://localhost:3000/");
    }


    @FindBy(id = "logIn")
    WebElement loginButton;

    @FindBy(tagName = "input")
    WebElement inputUserEmail;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitLoginButton;

    public String getTextOfLoginButton(){
        return loginButton.getText();
    }
    public UserDashboard loginApplication(String email){
        loginButton.click();
        inputUserEmail.sendKeys(email);
        submitLoginButton.click();
        UserDashboard userDashboard = new UserDashboard(driver);
        waitForElementToAppear("http://localhost:3000/dashboard");
        return userDashboard;
    }


}
