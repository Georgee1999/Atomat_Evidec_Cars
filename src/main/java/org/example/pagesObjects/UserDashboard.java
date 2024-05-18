package org.example.pagesObjects;

import org.example.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserDashboard extends AbstractComponent {

    WebDriver driver;

    public UserDashboard(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }





}
