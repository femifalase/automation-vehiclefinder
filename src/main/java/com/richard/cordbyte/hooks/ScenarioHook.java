package com.richard.cordbyte.hooks;

import com.richard.cordbyte.base.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScenarioHook {


    @Before
    public void beforeScenario() {

        Driver.startBrowser();

    }


    @After
    public void afterScenario(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) Driver.startBrowser()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");

        Driver.quitBrowser();

    }

}
