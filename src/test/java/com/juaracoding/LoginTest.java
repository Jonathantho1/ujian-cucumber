package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
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

public class LoginTest {
    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeAll
    public static void setup(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    //TCC.SHOP.001
    @Given("User enter url shop")
    public void user_enter_url_shop(){
        driver.get(Constants.URL);
    }

    @When("User input username")
    public void user_input_username(){
        loginPage.setUsername("standard_user");
    }

    @And("User input password")
    public void user_input_password(){
        loginPage.setPassword("secret_sauce");
    }

    @And("User click login")
    public void user_click_login(){
        loginPage.setLoginButton();
    }

    @Then("User get text product title")
    public void user_get_text_product_title(){
        Assert.assertEquals(loginPage.getProductTitle(),"Products");
    }

    //TCC.SHOP.002
    @Given("User click burger menu")
    public void user_click_burger_menu(){
        loginPage.setMenuButton();
    }

    @When("User click logout")
    public void user_click_logout(){
        loginPage.setLogoutButton();
    }

    @And("User input invalid username")
    public void user_input_invalid_username(){
        loginPage.setUsername("standard_users");
    }

    @Then("User get text error invalid")
    public void user_get_text_error_invalid(){
        Assert.assertEquals(loginPage.setErrorInvalid(),"Epic sadface: Username and password do not match any user in this service");
    }

    //TCC.SHOP.003
    @Then("User get text error required")
    public void user_get_text_error_required(){
        Assert.assertEquals(loginPage.setErrorRequired(),"Epic sadface: Username is required");
    }

}
