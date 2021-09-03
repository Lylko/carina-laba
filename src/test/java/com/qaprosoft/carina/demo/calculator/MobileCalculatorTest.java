package com.qaprosoft.carina.demo.calculator;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.DisplayField;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.NumberPad;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.OperatorPad;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileCalculatorTest implements IAbstractTest {

    @Test()
    public void testNumPad(){
        NumberPad numberPad = new NumberPad(getDriver());
        numberPad.tapDigitOnPad("1");
        pause(5);
        numberPad.tapDigitOnPad("3");
        numberPad.tapDigitOnPad("2");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapDeleteBtn();
        pause(5);

    }

    @Test()
    public void testResultScreen(){
        NumberPad numberPad = new NumberPad(getDriver());
        numberPad.tapDigitOnPad("61");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapPlusBtn();

        numberPad.tapDigitOnPad("4");
        operatorPad.tapEqualsBtn();

        DisplayField displayField = new DisplayField(getDriver());
        displayField.getResultFieldText();
        Assert.assertEquals(displayField.getResultFieldText(), "65", "Oh, shit! Here we go again!");
    }
}
