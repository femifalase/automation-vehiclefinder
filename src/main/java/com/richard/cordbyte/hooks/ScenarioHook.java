package com.richard.cordbyte.hooks;

import com.richard.cordbyte.base.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScenarioHook {

    private WebDriver driver;

    public ScenarioHook(Driver driver) {
        this.driver = driver.getDriver();
    }

    @Before
    public void beforeScenario() {

    }


    @After
    public void afterScenario(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");

    }

}
