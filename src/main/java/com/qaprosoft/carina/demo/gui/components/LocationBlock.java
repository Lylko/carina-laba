package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LocationBlock extends AbstractUIObject {

    @FindBy(xpath = "//select[@id = \"GLUXCountryList\"]")
    private ExtendedWebElement locationSelector;

    @FindBy(xpath = "//div[@class =\"a-popover-wrapper\"]//a[contains(text(),\"Canada\")]")
    private ExtendedWebElement changeToCanadaBtn;

    @FindBy(xpath = "//div[@class=\"a-popover-wrapper\"]//button[@type=\"button\"]")
    private ExtendedWebElement submitBtn;

    public LocationBlock(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getLocationSelector() {
        return locationSelector;
    }

    public ExtendedWebElement getChangeToCanadaBtn() {
        return changeToCanadaBtn;
    }

    public ExtendedWebElement getSubmitBtn() {
        return submitBtn;
    }
}
