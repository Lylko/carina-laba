package com.qaprosoft.carina.demo.amazon;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.demo.gui.components.*;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.apache.commons.collections.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;

import java.util.ArrayList;
import java.util.Collections;
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

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getLoginBtn().click();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.makeLogin();

        Assert.assertEquals(home.getHelloText(), "Hello, Igor", "User not authorised");

    }

//    !!!!
    @Test()
    public void testSignOut(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getLoginBtn().click();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.makeLogin();

        Assert.assertEquals(home.getHelloText(), "Hello, Igor", "User not authorised");
        navigationTools.getLoginBtn().hover();
        home.getSignOutBtn().click();
        home.open();
        Assert.assertTrue(home.getHelloText().contains("Sign in"), "User is not logged out!");

    }

    @Test()
    public void testIncorrectMail(){

        HomePage home = new HomePage(getDriver());
        home.open();

        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getLoginBtn().click();
        LoginPage loginPage = new LoginPage(getDriver());
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

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getChangeLangBtn().click();

        LanguageSettingPage languageSettingPage = new LanguageSettingPage(getDriver());
        languageSettingPage.getDeutschLangBtn().click();
        languageSettingPage.getSaveBtn().click();

        Assert.assertEquals(home.getHelloText(), "Hallo, Anmelden",
                "Language is not changed");

    }

    @Test()
    public void testSortMethod(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationMenu navigationMenu = new NavigationMenu(getDriver());
        navigationMenu.openDealsPage();

        DealsAndPromotionsPage dealsPage = new DealsAndPromotionsPage(getDriver());
        Assert.assertEquals(dealsPage.getPageName(), "Deals and Promotions",
                "Page with deals is not opened");
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
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationMenu navigationMenu = new NavigationMenu(getDriver());
        navigationMenu.openDealsPage();

        DealsAndPromotionsPage dealsPage = new DealsAndPromotionsPage(getDriver());
        Assert.assertEquals(dealsPage.getPageName(), "Deals and Promotions",
                "Page with deals is not opened");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.changeCountry();
        int prev = navigationTools.getCartCount();

        int randomNum = (int) (Math.random() * dealsPage.getListOfDeals().size());
        DealsItem item = dealsPage.getOnlyAvailableDeals().get(randomNum);
        item.getAddToCartBtn().click();
        Assert.assertTrue(navigationTools.getCartCount() > prev,
                "Product not added to cart via deal page!");

    }

    @Test()
    public void testDeleteFromCart(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getLoginBtn().click();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.makeLogin();
        Assert.assertEquals(home.getHelloText(), "Hello, Igor", "User not authorised");

        navigationTools.changeCountry();
        Assert.assertTrue(navigationTools.getCountryName().contains("Canada"));
        navigationTools.getSearchBtn().click();
        navigationTools.getSearchField().type("keyboard");
        navigationTools.getSearchBtn().click();

        SearchPage searchPage = new SearchPage(getDriver());
        Assert.assertFalse(CollectionUtils.isEmpty(searchPage.getSearchItems()), "No available items found!");
        int randomNum = (int) (Math.random() * searchPage.getSearchItems().size());
        SearchItem item = searchPage.getSearchItems().get(randomNum);
        item.getLinkToItem().click();

        ItemPage itemPage = new ItemPage(getDriver());
        int prev = navigationTools.getCartCount();
        itemPage.getAddToCartBtn().click();
        pause(3);
        home.open();
        Assert.assertTrue(navigationTools.getCartCount() > prev, "Product not added to cart!");

        navigationTools.getCartBtn().click();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened!");
        prev = navigationTools.getCartCount();
        cartPage.getListOfCartItems().get(0).getDeleteBtn().click();
        Assert.assertTrue(navigationTools.getCartCount() < prev, "Product not deleted from cart!");

    }

    @Test()
    public void testSearchField(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getSearchField().click();
        navigationTools.getSearchField().type("RTX 2060");
        navigationTools.getSearchBtn().click();

        SearchPage searchPage = new SearchPage(getDriver());
        List<SearchItem> searchItems = searchPage.getSearchItems();
        Assert.assertFalse(CollectionUtils.isEmpty(searchItems), "No available items found!");

        int n = Math.min(searchItems.size(), 5);
        for (int i = 0; i < n; i++){
            Assert.assertTrue(searchItems.get(i).getLinkToItem().getText().contains("RTX 2060"));
        }

    }

    @Test()
    public void testChangingAccountName(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getLoginBtn().click();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.makeLogin();
        Assert.assertEquals(home.getHelloText(), "Hello, Igor", "User not authorised");

        navigationTools.getLoginBtn().hover();
        navigationTools.getAccountBtn().click();

        AccountPage accountPage = new AccountPage(getDriver());
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened!");
        accountPage.getLoginAndSecurityBtn().click();

        SecurityPage securityPage = new SecurityPage(getDriver());
        securityPage.getEditNameBtn().click();
        securityPage.getChangeNameField().type("asd");
        securityPage.getSaveBtn().click();
        Assert.assertTrue(home.getHelloText().contains("asd"), "Name is not changed");

        home.open();

        navigationTools.getLoginBtn().hover();
        navigationTools.getAccountBtn().click();

        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened!");
        accountPage.getLoginAndSecurityBtn().click();
        securityPage.getEditNameBtn().click();
        securityPage.getChangeNameField().type("Igor");
        securityPage.getSaveBtn().click();

    }

    @Test()
    public void testCurrencyChanger(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.getChangeLangBtn().click();

        LanguageSettingPage languageSettingPage = new LanguageSettingPage(getDriver());
        languageSettingPage.getChangeCurrencyBtn().click();
        languageSettingPage.getChangeToRubBtn().click();
        languageSettingPage.getSaveBtn().click();

        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        navigationTools.getSearchField().type("samsung");
        navigationTools.getSearchBtn().click();

        SearchPage searchPage = new SearchPage(getDriver());

        Assert.assertTrue(searchPage.getSearchItems().get(0).getItemCurrency().contains("RUB"),
                "Currency is not correct!");
    }

}

