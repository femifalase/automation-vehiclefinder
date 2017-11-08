package com.richard.cordbyte.pages;

import com.richard.cordbyte.base.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public abstract class BasePage {

    protected WebDriver driver;

    private final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(this.driver, this);
    }

    public void navigateToPage(String url) {
        LOG.info("Opening homepage - " + url);
        driver.get(url);
    }

    public void checkPageTitle(String title) {
        LOG.info("Page title - " + title);
        assertThat(driver.getTitle(), is(title));
    }
}
