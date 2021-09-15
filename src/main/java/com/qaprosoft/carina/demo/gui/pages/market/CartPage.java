package com.qaprosoft.carina.demo.gui.pages.market;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.market.CartItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@id, 'sc-item')]")
    private List<CartItem> listOfCartItems;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("/gp/cart/view.html?ref_=nav_cart");
    }

    public List<CartItem> getListOfCartItems() {
        return listOfCartItems;
    }
}
