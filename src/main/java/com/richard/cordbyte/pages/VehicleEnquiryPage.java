package com.richard.cordbyte.pages;

import com.richard.cordbyte.base.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VehicleEnquiryPage extends BasePage {


    @FindBy(xpath = "//input[@id='Vrm']")
    private WebElement input_vrm;

    @FindBy(xpath = "//button[@name='Continue']")
    private WebElement btn_continue;

    private final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public void enter_registration(String reg) {
        input_vrm.sendKeys(reg);
    }

    public void click_continue() {
        btn_continue.click();
    }
}
