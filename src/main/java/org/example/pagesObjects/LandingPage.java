package org.example.pagesObjects;

import org.example.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

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
    @FindBy(xpath = "//div[contains(text(),'Uživatel s tímto e-mailem neexistuje!')]")
    WebElement errorLoginMessage;
    @FindBy(xpath = "//div[@class='errorMessage']")
    WebElement errorRegisterMessage;
    @FindBy(xpath = "//button[normalize-space()='Registrovat']")
    WebElement registerButton;
    @FindBy(xpath = "//span[normalize-space()='Evidence Aut']")
    WebElement iconButton;
    List<WebElement> enableElements;

    @FindBy(tagName = "input")
    WebElement inputUserEmail;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitLoginButton;

    @FindBy(xpath = "//div[@role='dialog']")
    WebElement modalLogin;
    @FindBy(xpath = "//div[@aria-label='Modal']")
    WebElement modalRegister;
    @FindBy(xpath = "//input[@placeholder=\'E-mail\']")
    WebElement inputEmailToRegisterUser;
    @FindBy(xpath = "//input[@placeholder=\'Jméno\']")
    WebElement inputFirstNameToRegisterUser;
    @FindBy(xpath = "//input[@placeholder=\'Příjmení\']")
    WebElement inputLastNameToRegisterUser;
    @FindBy(xpath = "//input[@placeholder=\'Adresa Bydliště\']")
    WebElement inputAddressToRegisterUser;

    @FindBy(xpath = "//button[@type=\'submit\']")
    WebElement submitRegisterButton;







// FUNCTIONAL (LOGIN)

    public UserDashboard loginApplication(String email){
        loginButton.click();
        inputUserEmail.sendKeys(email);
        submitLoginButton.click();
        UserDashboard userDashboard = new UserDashboard(driver);
        waitForElementToAppear("http://localhost:3000/dashboard");
        return userDashboard;
    }
    public String invalidEmailLogin(String email){
        loginButton.click();
        inputUserEmail.sendKeys(email);
        submitLoginButton.click();
        waitForElementIsVisible(errorLoginMessage);
        return errorLoginMessage.getText();
    }

// FUNCTIONAL (REGISTER)
    public UserDashboard register(String email, String firstName, String lastName, String address){
        registerButton.click();
        inputEmailToRegisterUser.sendKeys(email);
        inputFirstNameToRegisterUser.sendKeys(firstName);
        inputLastNameToRegisterUser.sendKeys(lastName);
        inputAddressToRegisterUser.sendKeys(address);
        submitRegisterButton.click();
        UserDashboard userDashboard = new UserDashboard(driver);
        waitForElementToAppear("http://localhost:3000/dashboard");
        return userDashboard;
    }
    public Boolean invalidEmailRegister(String email, String firstName, String lastName, String address){
        registerButton.click();
        inputEmailToRegisterUser.sendKeys(email);
        inputFirstNameToRegisterUser.sendKeys(firstName);
        inputLastNameToRegisterUser.sendKeys(lastName);
        inputAddressToRegisterUser.sendKeys(address);
        submitRegisterButton.click();
        waitForElementIsVisible(errorRegisterMessage);
        return errorRegisterMessage.isDisplayed();
    }

// UI
    public String getTextOfLoginButton(){
        return loginButton.getText();
    }
    public String getTextOfRegisterButton(){
        return registerButton.getText();
    }
    public String getTextOfIconButton(){
        return iconButton.getText();
    }
    public Boolean isEnable() {
        enableElements = Arrays.asList(loginButton, registerButton, iconButton);
        return enableElements.stream().allMatch(WebElement::isEnabled);
    }
    public boolean appearLoginModal(){
        loginButton.click();
        return modalLogin.isDisplayed();
    }
    public boolean appearRegisterModal(){
        registerButton.click();
        return modalRegister.isDisplayed();
    }
}
