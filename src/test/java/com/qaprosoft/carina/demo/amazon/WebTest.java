package com.qaprosoft.carina.demo.amazon;

import com.qaprosoft.carina.demo.gui.components.*;
import com.qaprosoft.carina.demo.gui.components.market.DealsItem;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.gui.pages.market.DealsAndPromotionsPage;
import com.qaprosoft.carina.demo.gui.pages.movie.MovieStorePage;
import com.qaprosoft.carina.demo.gui.pages.movie.WatchListPage;
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
    public void testSignOut(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.tapLoginBtn();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.makeLogin();

        Assert.assertEquals(home.getHelloText(), "Hello, Igor", "User not authorised");
        navigationTools.hoverLoginBtn();
        navigationTools.tapSignOutBtn();
        home.open();
        Assert.assertTrue(home.getHelloText().contains("Sign in"), "User is not logged out!");

    }

    @Test()
    public void testIncorrectMail(){

        HomePage home = new HomePage(getDriver());
        home.open();

        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.tapLoginBtn();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.typeLogin("unigorn@mail.ru");
        loginPage.tapContinueBtn();
        Assert.assertEquals(loginPage.getNotFoundMailText(), "We cannot find an account with that " +
                "email address", "Message doesnt exist.");

    }

    @Test()
    public void testChangeLangBtn(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.tapChangeLangBtn();

        LanguageSettingPage languageSettingPage = new LanguageSettingPage(getDriver());
        languageSettingPage.tapDeutschLangBtn();
        languageSettingPage.tapSaveBtn();

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
        dealsPage.tapSortBtn();
        dealsPage.tapSortHighToLowBtn();
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
    public void testSearchField(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.typeInSearchField("RTX 2060");
        navigationTools.tapSearchBtn();

        SearchPage searchPage = new SearchPage(getDriver());
        List<SearchItem> searchItems = searchPage.getSearchItems();
        Assert.assertFalse(CollectionUtils.isEmpty(searchItems), "No available items found!");

        int n = Math.min(searchItems.size(), 5);
        for (int i = 0; i < n; i++){
            Assert.assertTrue(searchItems.get(i).getLinkToItemText().contains("RTX 2060"));
        }

    }

    @Test()
    public void testCurrencyChanger(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.tapChangeLangBtn();

        LanguageSettingPage languageSettingPage = new LanguageSettingPage(getDriver());
        languageSettingPage.tapChangeCurrencyBtn();
        languageSettingPage.tapChangeToRubBtn();
        languageSettingPage.tapSaveBtn();

        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        navigationTools.typeInSearchField("samsung");
        navigationTools.tapSearchBtn();

        SearchPage searchPage = new SearchPage(getDriver());

        Assert.assertTrue(searchPage.getSearchItems().get(0).getItemCurrency().contains("RUB"),
                "Currency is not correct!");
    }

    @Test()
    public void testWatchListItems(){

        HomePage home = new HomePage(getDriver());
        home.open();

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.tapLoginBtn();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.makeLogin();

        navigationTools.openWatchListPage();

        WatchListPage watchListPage = new WatchListPage(getDriver());
        watchListPage.chooseMovieCategory();

        Assert.assertTrue(watchListPage.getListOfMovies().get(0).getMovieName().
                contains("Are We Done"), "Name is incorrect");
    }

}

