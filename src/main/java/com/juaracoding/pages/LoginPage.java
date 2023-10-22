package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productTitle;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menuButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logoutButton;

    //  Epic sadface: Username and password do not match any user in this service
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorInvalid;

    //Epic sadface: Username is required
    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement errorRequired;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void setUsername(String username){
        this.username.sendKeys(username);
    }

    public void setPassword(String password){
        this.password.sendKeys(password);
    }

    public void setLoginButton(){
        loginButton.click();
    }

    public void setMenuButton(){
        menuButton.click();
    }

    public String getProductTitle(){
        return productTitle.getText();
    }

    public void setLogoutButton(){
        logoutButton.click();
    }

    public String setErrorInvalid(){
        return errorInvalid.getText();
    }

    public String setErrorRequired(){
        return errorRequired.getText();
    }

}
