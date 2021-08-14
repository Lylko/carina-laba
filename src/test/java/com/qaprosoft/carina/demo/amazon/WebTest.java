package com.qaprosoft.carina.demo.amazon;

import com.qaprosoft.carina.demo.gui.components.amazon.DealsItem;
import com.qaprosoft.carina.demo.gui.components.amazon.NavigationMenu;
import com.qaprosoft.carina.demo.gui.components.amazon.NavigationTools;
import com.qaprosoft.carina.demo.gui.components.amazon.SearchItem;
import com.qaprosoft.carina.demo.gui.pages.amazon.DealsAndPromotionsPage;
import com.qaprosoft.carina.demo.gui.pages.amazon.HomePage;
import com.qaprosoft.carina.demo.gui.pages.amazon.SearchPage;
import com.qaprosoft.carina.demo.gui.pages.amazon.loginPage;
import io.cucumber.java.eo.Do;
import org.apache.commons.collections.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebTest implements IAbstractTest {

    @Test()
    public void testLogin(){

        HomePage home = new HomePage(getDriver());
        home.open();

        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        home.getLoginBtn().click();
        loginPage loginPage = new loginPage(getDriver());
        loginPage.getEmailField().type("androsov406@gmail.com");
        loginPage.getContinueBtn().click();
        loginPage.getPassField().type("QWSAqwsa1234");
        loginPage.getSignBtn().click();
        Assert.assertEquals(home.getHelloText(), "Hello, Igor", "User not authorised");

    }

//    !!!!
    @Test()
    public void testSignOut(){

        HomePage home = new HomePage(getDriver());
        home.open();

        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        home.getLoginBtn().click();
        loginPage loginPage = new loginPage(getDriver());
        loginPage.getEmailField().type("androsov406@gmail.com");
        loginPage.getContinueBtn().click();
        loginPage.getPassField().type("QWSAqwsa1234");
        loginPage.getSignBtn().click();
        Assert.assertEquals(home.getHelloText(), "Hello, Igor", "User not authorised");
        home.getLoginBtn().hover();
        home.getSignOutBtn().click();

    }

    @Test()
    public void testIncorrectMail(){

        HomePage home = new HomePage(getDriver());
        home.open();

        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        home.getLoginBtn().click();
        loginPage loginPage = new loginPage(getDriver());
        loginPage.getEmailField().type("unigorn@mail.ru");
        loginPage.getContinueBtn().click();
        Assert.assertEquals(loginPage.getNotFoundMail(), "We cannot find an account with that " +
                "email address", "Message doesnt exist.");

    }

    @Test()
    public void testChangeLangBtn(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.getChangeLangBtn().hover();
        home.getDeutschLangBtn().click();
        Assert.assertEquals(home.getHelloText(), "Hallo, Anmelden", "Language is not changed");

    }

    @Test()
    public void testSortMethod(){

        HomePage home = new HomePage(getDriver());
        home.open();

        NavigationMenu navigationMenu = new NavigationMenu(getDriver());
        navigationMenu.openDealsPage();

        DealsAndPromotionsPage dealsPage = new DealsAndPromotionsPage(getDriver());
        Assert.assertEquals(dealsPage.getPageName(), "Deals and Promotions", "Page with deals is not opened");
        dealsPage.getSortBtn().click();
        dealsPage.getSortHighToLowBtn().click();
        List<DealsItem> dealsItems = dealsPage.getListOfDeals();
        Assert.assertFalse(CollectionUtils.isEmpty(dealsItems), "No deals found!");
        List<Double> priceList = new ArrayList<>();
        List<Double> priceListClone = new ArrayList<>();
        for (DealsItem item : dealsItems){
            priceList.add(item.getDealPrice());
            priceListClone.add(item.getDealPrice());
        }
        Collections.sort(priceList);
        Collections.reverse(priceList);
        Assert.assertEquals(priceListClone, priceList, "Sorted incorrectly!");

    }

    @Test()
    public void testAddingToCart(){

        HomePage home = new HomePage(getDriver());
        home.open();

        NavigationMenu navigationMenu = new NavigationMenu(getDriver());
        navigationMenu.openDealsPage();

        DealsAndPromotionsPage dealsPage = new DealsAndPromotionsPage(getDriver());
        Assert.assertEquals(dealsPage.getPageName(), "Deals and Promotions", "Page with deals is not opened");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        int prev = navigationTools.getCartCount();

        int randomNum = (int) (Math.random() * dealsPage.getListOfDeals().size());
        DealsItem item = dealsPage.getOnlyAvailableDeals().get(randomNum);
        System.out.println(item.getDealPrice());
        item.getAddToCartBtn().click();
        Assert.assertTrue(navigationTools.getCartCount() > prev, "Product not added to cart via deal page!");

    }

    @Test()
    public void testDeleteFromCart(){

        HomePage home = new HomePage(getDriver());
        home.open();

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getSearchBtn().click();
        navigationTools.getSearchField().type("keyboard");
        navigationTools.getSearchBtn().click();

        SearchPage searchPage = new SearchPage(getDriver());
        Assert.assertFalse(CollectionUtils.isEmpty(searchPage.getAvailableForBuyItems()), "No available items found!");
        searchPage.getAvailableForBuyItems().get(0).getLinkToItem().click();


    }

}

