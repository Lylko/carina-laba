package com.qaprosoft.carina.demo.gui.components.amazon;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchItem extends AbstractUIObject {

    @FindBy(xpath = ".//h2/a")
    private ExtendedWebElement linkToItem;

    @FindBy(xpath = ".//span[@class = \"a-price-whole\"]")
    private ExtendedWebElement itemPrice;

    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getLinkToItem() {
        return this.linkToItem;
    }

    public Double getItemPrice() {
        return Double.parseDouble(itemPrice.getText());
    }
}
