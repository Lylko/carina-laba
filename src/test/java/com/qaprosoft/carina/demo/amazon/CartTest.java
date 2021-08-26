package com.qaprosoft.carina.demo.amazon;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.CartItem;
import com.qaprosoft.carina.demo.gui.components.NavigationTools;
import com.qaprosoft.carina.demo.gui.components.SearchItem;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.apache.commons.collections.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest implements IAbstractTest {

    @BeforeMethod()
    public void login(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.tapLoginBtn();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.makeLogin();
        Assert.assertFalse(home.getHelloText().contains("Sign in"), "User not authorised");

    }

    @AfterClass()
    public void clearCart(){

        login();
        NavigationTools navigationTools = new NavigationTools(getDriver());

        navigationTools.tapCartBtn();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        int prev = navigationTools.getCartCount();
        for (CartItem item : cartPage.getListOfCartItems()){
            item.tapDeleteBtn();
            Assert.assertTrue(navigationTools.getCartCount() < prev, "Product not deleted from cart!");
        }

    }

    @Test()
    public void testAddingToCart(){

        NavigationTools navigationTools = new NavigationTools(getDriver());
        HomePage home = new HomePage(getDriver());

        navigationTools.changeCountry();
        Assert.assertTrue(navigationTools.getCountryName().contains("Canada"));
        navigationTools.tapSearchBtn();
        navigationTools.typeInSearchField("keyboard");
        navigationTools.tapSearchBtn();

        SearchPage searchPage = new SearchPage(getDriver());
        Assert.assertFalse(CollectionUtils.isEmpty(searchPage.getSearchItems()), "No available items found!");
        int randomNum = (int) (Math.random() * searchPage.getSearchItems().size());
        SearchItem item = searchPage.getSearchItems().get(randomNum);
        item.tapLinkToItem();

        ItemPage itemPage = new ItemPage(getDriver());
        int prev = navigationTools.getCartCount();
        itemPage.tapAddToCartBtn();
        pause(3);
        home.open();
        Assert.assertTrue(navigationTools.getCartCount() > prev, "Product not added to cart!");

    }

    @Test()
    public void testDeleteFromCart(){

        NavigationTools navigationTools = new NavigationTools(getDriver());
        HomePage home = new HomePage(getDriver());

        navigationTools.changeCountry();
        Assert.assertTrue(navigationTools.getCountryName().contains("Canada"));
        navigationTools.tapSearchBtn();
        navigationTools.typeInSearchField("keyboard");
        navigationTools.tapSearchBtn();

        SearchPage searchPage = new SearchPage(getDriver());
        Assert.assertFalse(CollectionUtils.isEmpty(searchPage.getSearchItems()), "No available items found!");
        int randomNum = (int) (Math.random() * searchPage.getSearchItems().size());
        SearchItem item = searchPage.getSearchItems().get(randomNum);
        item.tapLinkToItem();

        ItemPage itemPage = new ItemPage(getDriver());
        int prev = navigationTools.getCartCount();
        itemPage.tapAddToCartBtn();
        pause(3);
        home.open();
        Assert.assertTrue(navigationTools.getCartCount() > prev, "Product not added to cart!");

        navigationTools.tapCartBtn();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        prev = navigationTools.getCartCount();
        cartPage.getListOfCartItems().get(0).tapDeleteBtn();
        Assert.assertTrue(navigationTools.getCartCount() < prev, "Product not deleted from cart!");

    }

}
