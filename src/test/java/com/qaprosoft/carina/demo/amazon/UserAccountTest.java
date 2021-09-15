package com.qaprosoft.carina.demo.amazon;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.NavigationTools;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.aspectj.lang.annotation.AfterReturning;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserAccountTest implements IAbstractTest {

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

    @AfterClass
    public void clearNameChanges(){

        NavigationTools navigationTools = new NavigationTools(getDriver());
        HomePage home = new HomePage(getDriver());

        navigationTools.tapLoginBtn();

        AccountPage accountPage = new AccountPage(getDriver());
        accountPage.tapLoginAndSecurityBtn();

        SecurityPage securityPage = new SecurityPage(getDriver());
        securityPage.tapEditNameBtn();
        securityPage.typeName("Igor");
        securityPage.tapSaveBtn();
        Assert.assertTrue(home.getHelloText().contains("Igor"), "Name is not changed");

    }

    @AfterClass()
    public void clearCurrencyChanges(){

        login();

        HomePage home = new HomePage(getDriver());

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

    @AfterClass()
    public void clearDeliveryZoneChanges(){

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.changeCountry("Belarus");
        Assert.assertEquals(navigationTools.getDeliveryZoneName(), "Belarus", "Incorrect delivery zone");


    }



    @Test()
    public void testChangingAccountName(){

        NavigationTools navigationTools = new NavigationTools(getDriver());
        HomePage home = new HomePage(getDriver());

        navigationTools.hoverLoginBtn();
        navigationTools.tapAccountBtn();

        AccountPage accountPage = new AccountPage(getDriver());
        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened!");
        accountPage.tapLoginAndSecurityBtn();

        SecurityPage securityPage = new SecurityPage(getDriver());
        securityPage.tapEditNameBtn();
        securityPage.typeName("asd");
        securityPage.tapSaveBtn();
        Assert.assertTrue(home.getHelloText().contains("asd"), "Name is not changed");

    }

    @Test()
    public void testCurrencyChanger(){

        HomePage home = new HomePage(getDriver());

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.tapChangeLangBtn();

        LanguageSettingPage languageSettingPage = new LanguageSettingPage(getDriver());
        languageSettingPage.tapChangeCurrencyBtn();
        languageSettingPage.tapChangeToUsdBtn();
        languageSettingPage.tapSaveBtn();

        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        navigationTools.typeInSearchField("samsung");
        navigationTools.tapSearchBtn();

        SearchPage searchPage = new SearchPage(getDriver());

        Assert.assertTrue(searchPage.getSearchItems().get(0).getItemCurrency().contains("$"),
                "Currency is not correct!");
    }

    @Test()
    public void testDeliveryZoneChange(){

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.changeCountry("Canada");
        Assert.assertEquals(navigationTools.getDeliveryZoneName(), "Canada", "Incorrect delivery zone");

    }

}
