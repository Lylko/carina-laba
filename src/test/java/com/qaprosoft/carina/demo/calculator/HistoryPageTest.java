package com.qaprosoft.carina.demo.calculator;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.common.HistoryPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.common.HomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HistoryPageTest implements IAbstractTest {

    @Test
    public void testOpenHistoryPage(){
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.openHistory();
        HistoryPageBase history = initPage(getDriver(), HistoryPageBase.class);
        Assert.assertTrue(history.isOpened(), "History page is not opened!");
    }

    @Test
    public void testOpenHistoryPageBySwipe(){
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.openHistoryBySwipe();
        HistoryPageBase history = initPage(getDriver(), HistoryPageBase.class);
        Assert.assertTrue(history.isOpened(), "History page is not opened!");
    }

    @Test
    public void testHistoryResult(){
        HomePageBase home = initPage(getDriver(), HomePageBase.class);

        home.tapDigitOnPad("55");
        home.tapMinusBtn();
        home.tapDigitOnPad("5");
        home.tapEqualsBtn();
        home.openHistoryBySwipe();
        HistoryPageBase history = initPage(getDriver(), HistoryPageBase.class);
        Assert.assertEquals(history.getHistoryResultText(), "50", "History result is not correct!");

    }

    @Test
    public void testHistoryPageWithoutOperations(){
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.openHistoryBySwipe();
        HistoryPageBase history = initPage(getDriver(), HistoryPageBase.class);
        Assert.assertTrue(history.isOpened(), "History is not clear!");
    }
}
