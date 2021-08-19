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

    @FindBy(xpath = "//span[contains(text(), 'Deliver to')]//ancestor::a")
    private ExtendedWebElement countryName;

    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    private ExtendedWebElement signOutBtn;

    public NavigationTools(WebDriver driver) {
        super(driver);
    }

    public void tapCartBtn() {
        cartBtn.click();
    }

    public int getCartCount() {
        return Integer.parseInt(cartCount.getText());
    }

    public void typeInSearchField(String request) {
        searchField.type(request);
    }

    public void tapSearchBtn() {
        searchBtn.click();
    }

    public void tapLocationBtn() {
        locationBtn.click();
    }

    public String getCountryName() {
        return countryName.getText();
    }

    public void tapChangeLangBtn() {
        changeLangBtn.click();
    }

    public void changeCountry(){
        LocationBlock locationBlock = new LocationBlock(getDriver());
        locationBtn.click();
        locationBlock.chooseLocationSelector();
        locationBlock.tapChangeToCanadaBtn();
        locationBlock.tapSubmitBtn();
    }

    public void tapSignOutBtn(){
        signOutBtn.click();
    }

    public void tapLoginBtn() {
        loginBtn.click();
    }

    public void hoverLoginBtn() {
        loginBtn.hover();
    }

    public void tapAccountBtn() {
        accountBtn.click();
    }
}
