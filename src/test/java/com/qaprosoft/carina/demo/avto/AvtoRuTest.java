package com.qaprosoft.carina.demo.avto;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.components.avto.OfferItem;
import com.qaprosoft.carina.demo.mobile.gui.pages.avto.android.HomePage;
import com.qaprosoft.carina.demo.mobile.gui.pages.avto.android.OptionsPage;
import io.appium.java_client.TouchAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AvtoRuTest implements IAbstractTest {

    @Test()
    public void testAuto(){
        pause(2);
        HomePage home = new HomePage(getDriver());
        home.tapOptionsBtn();

        OptionsPage optionsPage = new OptionsPage(getDriver());
        optionsPage.chooseNewCars();
        optionsPage.tapClearLocationBtn();
        optionsPage.tapSearchBtn();

        OfferItem offerItem = new OfferItem(getDriver());
        System.out.println(offerItem.getCarName());


    }
}
