package com.demo.digital.testautomation.testrunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arlene.lehakra on 10/04/2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = ".\\src\\test\\resources\\features\\",
        tags= {"@test"},
        glue= "com.demo.digital.testautomation.stepdefs"
)
public class TestRunner {

}
