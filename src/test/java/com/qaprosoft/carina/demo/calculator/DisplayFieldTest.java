package com.qaprosoft.carina.demo.calculator;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.DisplayField;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.NumberPad;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.OperatorPad;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.android.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayFieldTest implements IAbstractTest {

    @Test()
    public void testFormulaField(){
        NumberPad numberPad = new NumberPad(getDriver());
        numberPad.tapDigitOnPad("129");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapDeleteBtn();

        DisplayField displayField = new DisplayField(getDriver());
        Assert.assertEquals(displayField.getFormula(), "12", "The field shows an incorrect result!");

    }

    @Test()
    public void testResultField(){
        NumberPad numberPad = new NumberPad(getDriver());
        numberPad.tapDigitOnPad("61");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapPlusBtn();

        numberPad.tapDigitOnPad("4");
        operatorPad.tapEqualsBtn();

        DisplayField displayField = new DisplayField(getDriver());
        Assert.assertEquals(displayField.getResultFieldText(), "65", "Oh, shit! Here we go again!");
    }

}
