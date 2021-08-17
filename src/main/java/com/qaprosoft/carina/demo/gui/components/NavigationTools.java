package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NavigationTools extends AbstractUIObject {

    @FindBy(xpath = "//a[@id = \"nav-cart\"]")
    private ExtendedWebElement cartBtn;

    @FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Account')]")
    private ExtendedWebElement accountBtn;

    @FindBy(xpath = "//a[@id = \"nav-global-location-popover-link\"]")
    private ExtendedWebElement locationBtn;

    @FindBy(xpath = "//a[@id='icp-nav-flyout']")
    private ExtendedWebElement changeLangBtn;

    @FindBy(xpath = "//div[@class = \"nav-search-field \"]/input")
    private ExtendedWebElement searchField;

    @FindBy(xpath = "//input[@id = \"nav-search-submit-button\"]")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//a[@id = \"nav-cart\"]//span[@id = \"nav-cart-count\"]")
    private ExtendedWebElement cartCount;

    @FindBy(xpath = "//span[contains(text(), \"Deliver to\")]//ancestor::a")
    private ExtendedWebElement countryName;

    public NavigationTools(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getCartBtn() {
        return cartBtn;
    }

    public int getCartCount() {
        return Integer.parseInt(cartCount.getText());
    }

    public ExtendedWebElement getSearchField() {
        return searchField;
    }

    public ExtendedWebElement getSearchBtn() {
        return searchBtn;
    }

    public ExtendedWebElement getLocationBtn() {
        return locationBtn;
    }

    public String getCountryName() {
        return countryName.getText();
    }

    public ExtendedWebElement getChangeLangBtn() {
        return changeLangBtn;
    }

    public void changeCountry(){
        LocationBlock locationBlock = new LocationBlock(getDriver());
        locationBtn.click();
        locationBlock.getLocationSelector().click();
        locationBlock.getChangeToCanadaBtn().click();
        locationBlock.getSubmitBtn().click();
    }

    public ExtendedWebElement getLoginBtn() {
        return loginBtn;
    }

    public ExtendedWebElement getAccountBtn() {
        return accountBtn;
    }
}
