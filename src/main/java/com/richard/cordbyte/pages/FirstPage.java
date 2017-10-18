package com.richard.cordbyte.pages;

import com.richard.cordbyte.base.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstPage extends BasePage {

    @FindBy(xpath = "//p[@id='get-started']/a[1]")
    private WebElement btn_start;

    private final Logger LOG = LoggerFactory.getLogger(BasePage.class);

    public FirstPage(Driver driver) {
        super(driver);
    }


    public void click_btn_start() {
        btn_start.click();
    }
}
