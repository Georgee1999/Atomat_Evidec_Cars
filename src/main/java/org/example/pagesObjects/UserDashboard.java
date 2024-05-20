package org.example.pagesObjects;

import org.example.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserDashboard extends AbstractComponent {

    WebDriver driver;

    public UserDashboard(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='UserInitials']")
    WebElement userInitials;
    @FindBy(xpath = "//button[normalize-space()='Odhlásit se']")
    WebElement logOutButton;
    @FindBy(xpath = "//button[normalize-space()='Vyhledat auta']")
    WebElement findCarsButton;
    @FindBy(xpath = "//button[normalize-space()='Registrovaná auta']")
    WebElement allCarsButton;
    @FindBy(xpath = "//button[normalize-space()='Smazat auto']")
    WebElement deleteCarButton;
    @FindBy(xpath = "//button[normalize-space()='Nové auto']")
    WebElement newCarButton;
    @FindBy(xpath = "//span[normalize-space()='Evidence Aut']")
    WebElement iconButton;
    List<WebElement> enableElements;

    @FindBy(xpath = "//input")
    WebElement inputEmailToFindCar;
    @FindBy(xpath = "//button[@type=\'submit\']")
    WebElement submitFindCarsButton;
    By cardEmails = By.xpath("//*[@id='card']/p[5]");

//FUNCTIONAL
    public List<String> findUsersCar(String email){
        findCarsButton.click();
        inputEmailToFindCar.sendKeys(email);
        submitFindCarsButton.click();
        List<WebElement> carsEmail = driver.findElements(cardEmails);
        List<String> carsEmailText = new ArrayList<>();

        for (WebElement carEmail : carsEmail) {
            String spz = carEmail.getText();
            carsEmailText.add(spz);
        }
        return carsEmailText;
    }







// UI
    public boolean userInitials(){
        return userInitials.isDisplayed();
    }
    public Boolean isEnable() {
        enableElements = Arrays.asList(logOutButton,findCarsButton,allCarsButton,deleteCarButton,newCarButton,iconButton );
        return enableElements.stream().allMatch(WebElement::isEnabled);
    }
    public String getTextOfLogOutButton(){
        return logOutButton.getText();
    }
    public String getTextOfFindCarsButton(){
        return findCarsButton.getText();
    }
    public String getTextOfAllCarsButton(){
        return allCarsButton.getText();
    }
    public String getTextOfDeleteCarButton(){
        return deleteCarButton.getText();
    }

    public String getTextOfNewCarButton(){
        return newCarButton.getText();
    }
    public String getTextOfIconButton(){
        return iconButton.getText();
    }




}
