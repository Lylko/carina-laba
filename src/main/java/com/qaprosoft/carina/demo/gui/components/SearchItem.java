package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchItem extends AbstractUIObject {

    @FindBy(xpath = ".//h2/a")
    private ExtendedWebElement linkToItem;

    @FindBy(xpath = ".//span[@class = 'a-price-whole']")
    private ExtendedWebElement itemPrice;

    @FindBy(xpath = ".//span[@class = 'a-price-symbol']")
    private ExtendedWebElement itemCurrency;

    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void tapLinkToItem() {
        linkToItem.click();
    }

    public String getLinkToItemText() {
        return linkToItem.getText();
    }

    public Double getItemPrice() {
        return Double.parseDouble(itemPrice.getText());
    }

    public String getItemCurrency(){
        return itemCurrency.getText();
    }

}
