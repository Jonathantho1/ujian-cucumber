package com.juaracoding;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = {"src/main/resources/features/Login.feature","src/main/resources/features/Checkout.feature"}, //path .feature
        glue = "com.juaracoding", //package
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber-json"} //output
)

public class RunnerTest extends AbstractTestNGCucumberTests {

}