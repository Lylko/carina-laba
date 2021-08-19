package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {

    @FindBy(id = "add-to-cart-button")
    private ExtendedWebElement addToCartBtn;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void tapAddToCartBtn() {
        addToCartBtn.click();
    }
}
