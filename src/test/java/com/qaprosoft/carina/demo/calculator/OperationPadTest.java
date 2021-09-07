package com.qaprosoft.carina.demo.calculator;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.common.HomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OperationPadTest implements IAbstractTest {

    @Test()
    public void testPlusOperation(){

        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.tapDigitOnPad("23");
        home.tapPlusBtn();
        home.tapDigitOnPad("2");
        home.tapEqualsBtn();
        Assert.assertEquals(home.getResultFieldText(), "25", "Incorrect result");
    }

    @Test()
    public void testMinusOperation(){

        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.tapDigitOnPad("123");
        home.tapMinusBtn();
        home.tapDigitOnPad("23");
        home.tapEqualsBtn();
        Assert.assertEquals(home.getResultFieldText(), "100", "Incorrect result");
    }

    @Test()
    public void testMultiplyOperation(){

        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.tapDigitOnPad("640");
        home.tapMultiplyBtn();
        home.tapDigitOnPad("3");
        home.tapEqualsBtn();
        Assert.assertEquals(home.getResultFieldText(), "1920", "Incorrect result");
    }

    @Test()
    public void testDivideOperation(){

        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.tapDigitOnPad("1024");
        home.tapDivideBtn();
        home.tapDigitOnPad("64");
        home.tapEqualsBtn();
        Assert.assertEquals(home.getResultFieldText(), "16", "Incorrect result");
    }

}
