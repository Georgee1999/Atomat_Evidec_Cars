package org.example.pagesObjects;

import org.example.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDashboard extends AbstractComponent {

    WebDriver driver;

    public UserDashboard(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='UserInitials']")
    WebElement userInitials;





// UI
    public boolean userInitials(){
        return userInitials.isDisplayed();
    }



}
