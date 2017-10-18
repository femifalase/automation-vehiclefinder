package com.richard.cordbyte.pages;

import com.richard.cordbyte.base.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConfirmVehiclePage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='reg-mark']")
    private WebElement txt_reg;

    @FindBy(xpath = "//span[text()='Make']/following-sibling::span[1]")
    private WebElement txt_make;

    @FindBy(xpath = "//span[text()='Colour']/following-sibling::span[1]")
    private WebElement txt_colour;

    private final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public ConfirmVehiclePage(Driver driver) {
        super(driver);
    }

    public void confirmRegMark(String regMark) {
        LOG.info("Vehicle Registration number - " + regMark);
        String displayedRegMark = txt_reg.getText().replace(" ", "");
        assertThat(regMark, is(displayedRegMark));
    }

    public void confirmMake(String make) {
        LOG.info("Vehicle Make - " + make);
        String displayedMake = txt_make.getText();
        assertThat(make, is(displayedMake));
    }

    public void confirmColour(String colour) {
        LOG.info("Vehicle Colour - " + colour);
        String displayedMake = txt_colour.getText();
        assertThat(colour, is(displayedMake));
    }
}
