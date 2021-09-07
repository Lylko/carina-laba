package com.qaprosoft.carina.demo.calculator;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.common.HomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayFieldTest implements IAbstractTest {

    @Test()
    public void testFormulaField(){
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.tapDigitOnPad("129");
        home.tapDeleteBtn();
        Assert.assertEquals(home.getFormula(), "12", "The field shows an incorrect result!");

    }

    @Test()
    public void testResultField(){
        HomePageBase home = initPage(getDriver(), HomePageBase.class);
        home.tapDigitOnPad("61");
        home.tapPlusBtn();
        home.tapDigitOnPad("4");
        home.tapEqualsBtn();
        Assert.assertEquals(home.getResultFieldText(), "65", "Oh, shit! Here we go again!");
    }

}
