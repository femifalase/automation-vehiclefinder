package com.richard.cordbyte.base;

import com.richard.cordbyte.utils.ReadFileData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static WebDriver driver;

    private final static String driverPath = "drivers/";

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ReadFileData.getProperties().getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {

                initChome();

            } else if (browser.equalsIgnoreCase("firefox")) {

                initFirefox();

            } else if (browser.equalsIgnoreCase("ie")) {

                initIEExplorer();

            }


        }

        return driver;

    }

    public static void quitBrowser(){
        driver.quit();
        driver = null;
    }


    private static void initIEExplorer() {
        System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private static void initChome() {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private static void initFirefox() {
        System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
