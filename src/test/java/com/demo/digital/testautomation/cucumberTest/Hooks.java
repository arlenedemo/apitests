package com.demo.digital.testautomation.cucumberTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) throws Exception{
        System.out.println("Starting scenario"+ scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) throws Exception{
        System.out.println("Finished scenario"+ scenario.getName());
    }
}
