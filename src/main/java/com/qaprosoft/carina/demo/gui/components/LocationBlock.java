package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LocationBlock extends AbstractUIObject {

    @FindBy(xpath = "//select[@id = 'GLUXCountryList']")
    private ExtendedWebElement locationSelector;

    @FindBy(xpath = "//div[@class = 'a-popover-wrapper']//button[@type = 'button']")
    private ExtendedWebElement submitBtn;

    public LocationBlock(WebDriver driver) {
        super(driver);
    }

    public void chooseLocationSelector() {
        locationSelector.click();
    }

    public void chooseCountry(String country) {
        ExtendedWebElement webElement = findExtendedWebElement(By.xpath
                ("//div[@class ='a-popover-wrapper']//a[contains(text(), '" + country + "')]"));
        webElement.click();
    }

    public void tapSubmitBtn() {
        submitBtn.click();
    }
}
