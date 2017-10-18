package com.richard.cordbyte.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver = null;

    static String driverPath = "drivers/";

    public WebDriver getDriver() {

        if (driver == null) {

            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        return driver;

    }
}
