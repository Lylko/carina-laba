package com.qaprosoft.carina.demo.avto;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.avto.android.HomePage;
import com.qaprosoft.carina.demo.mobile.gui.pages.avto.android.OfferPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.avto.android.OptionsPage;
import org.testng.annotations.Test;

public class AvtoRuTest implements IAbstractTest {

    @Test()
    public void testAuto(){

        HomePage home = new HomePage(getDriver());
        home.tapOptionsBtn();

        OptionsPage optionsPage = new OptionsPage(getDriver());
        optionsPage.chooseNewCars();
        optionsPage.tapClearLocationBtn();
        optionsPage.tapSearchBtn();
//
//        OfferPage offerPage = new OfferPage(getDriver());
//        offerPage.swipePage();
//        for (OfferItem offerItem : offerPage.getOfferItemList()){
//            System.out.println(offerItem.getCarName());
//        }
    }

}
