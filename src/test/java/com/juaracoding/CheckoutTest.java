package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static CheckoutPage checkoutPage;

    @BeforeAll
    public static void setup(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
        checkoutPage = new CheckoutPage();

    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    //TCC.SHOP.004
    @Given("User entering url shop")
    public void user_enter_url_shop(){
       driver.get(Constants.URL);
    }

    @When("User login")
    public void user_login(){
        loginPage.login("standard_user","secret_sauce");
    }

    @And("User click item add to cart")
    public void user_click_item_add_to_cart(){
        checkoutPage.setSauceLabsBackpacks();
    }

    @And("User click cart")
    public void user_click_cart(){
        checkoutPage.setCart();
    }

    @And("User click checkout")
    public void user_click_checkout(){
        checkoutPage.setCheckout();
    }

    @And("User input firstname")
    public void user_input_firstname(){
        checkoutPage.setFirstname("Jonathan");
    }

    @And("User Input lastname")
    public void user_input_lastname(){
        checkoutPage.setLastname("Tho");
    }

    @And("User Input zipcode")
    public void user_input_zipcode(){
        checkoutPage.setZipcode("25117");
    }

    @And("User click continue")
    public void user_click_continue(){
        checkoutPage.setContinueButton();
    }

    @And("User click finish")
    public void user_click_finish(){
        checkoutPage.setFinish();
    }

    @Then("User get text thank you")
    public void user_get_text_thank_you(){
        Assert.assertEquals(checkoutPage.getThankYou(),"Thank you for your order!");
    }

    //TCC.SHOP.005
    @Given("User click back home")
    public void user_click_back_home(){
        checkoutPage.setBackHome();
    }

    @Then("User get text error firstname required")
    public void user_get_text_error_firstname_required(){
        Assert.assertEquals(checkoutPage.getErrorRequired(),"Error: First Name is required");
    }

    //TCC.SHOP.006
    @Then("User get text error lastname required")
    public void user_get_text_error_lastname_required(){
        Assert.assertEquals(checkoutPage.getErrorRequired(),"Error: Last Name is required");
    }
}
