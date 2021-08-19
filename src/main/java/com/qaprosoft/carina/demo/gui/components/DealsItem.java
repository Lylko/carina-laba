package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class DealsItem extends AbstractUIObject {

    private String typeOfItem;

    @FindBy(xpath = ".//span[contains(@class, 'dealPriceText')]")
    private ExtendedWebElement dealPrice;

    @FindBy(xpath = ".//button[@type = 'button']")
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = ".//a[@role = 'button']")
    private ExtendedWebElement dealBtn;

    public DealsItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Double getDealPrice(){
        String[] array = this.dealPrice.getText().replaceAll("\\$", "").replaceAll(",", "").split(" ");
        return Double.parseDouble(array[0]);
    }

    public void tapAddToCartBtn() {
        addToCartBtn.click();
    }

    public String getAddToCartText() {
        return addToCartBtn.getText();
    }



}
