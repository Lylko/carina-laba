package com.qaprosoft.carina.demo.gui.components.amazon;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigationTools extends AbstractUIObject {

    @FindBy(xpath = "//a[@id = \"nav-cart\"]")
    private ExtendedWebElement cartBtn;

    @FindBy(xpath = "//div[@class = \"nav-search-field \"]/input")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//input[@id = \"nav-search-submit-button\"]")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//a[@id = \"nav-cart\"]//span[@id = \"nav-cart-count\"]")
    private ExtendedWebElement cartCount;

    public NavigationTools(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getCartBtn() {
        return this.cartBtn;
    }

    public int getCartCount() {
        return Integer.parseInt(cartCount.getText());
    }

    public ExtendedWebElement getSearchField() {
        return this.searchField;
    }

    public ExtendedWebElement getSearchBtn() {
        return this.searchBtn;
    }
}
