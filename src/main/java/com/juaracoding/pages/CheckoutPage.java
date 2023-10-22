package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement sauceLabsBackpacks;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cart;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkout;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstname;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastname;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipcode;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    //Error: First Name is required
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorRequired;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finish;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement thankYou;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHome;

    public void setSauceLabsBackpacks(){
        sauceLabsBackpacks.click();
    }

    public void setCart(){
        cart.click();
    }

    public void setCheckout(){
        checkout.click();
    }

    public void setFirstname(String firstname){
        this.firstname.sendKeys(firstname);
    }

    public void setLastname(String lastname){
        this.lastname.sendKeys(lastname);
    }

    public void setZipcode(String zipcode){
        this.zipcode.sendKeys(zipcode);
    }

    public void setContinueButton(){
        continueButton.click();
    }

    public String getErrorRequired(){
        return errorRequired.getText();
    }

    public void setFinish(){
        finish.click();
    }

    public String getThankYou(){
        return thankYou.getText();
    }

    public void setBackHome(){
        backHome.click();
    }
}
