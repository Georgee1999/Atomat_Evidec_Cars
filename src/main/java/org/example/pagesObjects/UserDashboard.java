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
    @FindBy(xpath = "//input[@placeholder='SPZ auta ke smazání']")
    WebElement inputSPZtoDelete;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDeleteButton;
    @FindBy(xpath = "//input[@placeholder=\'SPZ\']")
    WebElement inputSPZtoAdd;
    @FindBy(xpath = "//input[@placeholder=\'Model\']")
    WebElement inputModelToAdd;
    @FindBy(xpath = "//input[@placeholder=\'Rok výroby\']")
    WebElement inputYearOfMade;
    @FindBy(xpath = "//input[@placeholder=\'Barva\']")
    WebElement inputColorToAdd;
    @FindBy(xpath = "//input[@placeholder=\'Email majitele\']")
    WebElement inputEmailToAdd;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonToAddCar;
    @FindBy(xpath = "//div[@role='dialog']")
    WebElement registerModal;

//CarsCardElements
    By cardEmails = By.xpath("//*[@id='card']/p[5]");
    By cardSPZ = By.xpath("//*[@id=\"card\"]/p[1]");

//FUNCTIONAL
    public List<String> findUsersCar(String email){
        findCarsButton.click();
        inputEmailToFindCar.sendKeys(email);
        submitFindCarsButton.click();
        List<WebElement> carsEmail = driver.findElements(cardEmails);
        List<String> carsEmailText = new ArrayList<>();

        for (WebElement carEmail : carsEmail) {
            String text = carEmail.getText();
            carsEmailText.add(text);
        }
        return carsEmailText;
    }

    public List<String> deleteCar(String spz) throws InterruptedException {
        deleteCarButton.click();
        inputSPZtoDelete.sendKeys(spz);
        submitDeleteButton.click();
        Thread.sleep(4000);
        List<WebElement> carsSPZ = driver.findElements(cardSPZ);
        List<String> carsSPZText = new ArrayList<>();
        for (WebElement carSPZ : carsSPZ){
            String text = carSPZ.getText();
            carsSPZText.add(text);
        }
        return carsSPZText;
    }
    public List<String> registerCar(String SPZ, String model, String yearOfMade, String color, String email ) throws InterruptedException {
        newCarButton.click();
        inputSPZtoAdd.sendKeys(SPZ);
        inputModelToAdd.sendKeys(model);
        inputYearOfMade.sendKeys(yearOfMade);
        inputColorToAdd.sendKeys(color);
        inputEmailToAdd.sendKeys(email);
        buttonToAddCar.click();
        waitForElementToDisappear(registerModal);
        //Thread.sleep(4000);// Tady musím napsat at počká než je viditelná zpráva ze se auto přidalo
        List<WebElement> carsSPZ = driver.findElements(cardSPZ);
        List<String> carsSPZText = new ArrayList<>();
        for (WebElement carSPZ : carsSPZ){
            String text = carSPZ.getText();
            carsSPZText.add(text);
        }
        return carsSPZText;
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
