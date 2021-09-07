package com.qaprosoft.carina.demo.calculator;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.NumberPad;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.OperatorPad;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.android.HistoryPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.android.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HistoryPageTest implements IAbstractTest {

    @Test
    public void testOpenHistoryPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.openHistory();

        HistoryPage history = new HistoryPage(getDriver());
        Assert.assertTrue(history.isOpened(), "History page is not opened!");
    }

    @Test
    public void testOpenHistoryPageBySwipe(){
        HomePage homePage = new HomePage(getDriver());
        homePage.openHistoryBySwipe();

        HistoryPage history = new HistoryPage(getDriver());
        Assert.assertTrue(history.isOpened(), "History page is not opened!");
    }

    @Test
    public void testHistoryResult(){
        HomePage home = new HomePage(getDriver());
        NumberPad numberPad = new NumberPad(getDriver());

        numberPad.tapDigitOnPad("55");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapMinusBtn();
        numberPad.tapDigitOnPad("5");
        operatorPad.tapEqualsBtn();

        home.openHistoryBySwipe();

        HistoryPage historyPage = new HistoryPage(getDriver());
        Assert.assertEquals(historyPage.getHistoryResultText(), "50", "History result is not correct!");

    }

    @Test
    public void testHistoryPageWithoutOperations(){
        HomePage home = new HomePage(getDriver());
        home.openHistoryBySwipe();

        HistoryPage historyPage = new HistoryPage(getDriver());
        Assert.assertTrue(historyPage.isOpened(), "History is not clear!");
    }
}
