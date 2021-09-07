package com.qaprosoft.carina.demo.calculator;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.DisplayField;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.NumberPad;
import com.qaprosoft.carina.demo.mobile.gui.components.calculator.OperatorPad;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OperationPadTest implements IAbstractTest {

    @Test()
    public void testPlusOperation(){

        NumberPad numberPad = new NumberPad(getDriver());
        numberPad.tapDigitOnPad("23");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapPlusBtn();
        numberPad.tapDigitOnPad("2");
        operatorPad.tapEqualsBtn();

        DisplayField displayField = new DisplayField(getDriver());
        Assert.assertEquals(displayField.getResultFieldText(), "25", "Incorrect result");
    }

    @Test()
    public void testMinusOperation(){

        NumberPad numberPad = new NumberPad(getDriver());
        numberPad.tapDigitOnPad("123");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapMinusBtn();
        numberPad.tapDigitOnPad("23");
        operatorPad.tapEqualsBtn();

        DisplayField displayField = new DisplayField(getDriver());
        Assert.assertEquals(displayField.getResultFieldText(), "100", "Incorrect result");
    }

    @Test()
    public void testMultiplyOperation(){

        NumberPad numberPad = new NumberPad(getDriver());
        numberPad.tapDigitOnPad("640");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapMultiplyBtn();
        numberPad.tapDigitOnPad("3");
        operatorPad.tapEqualsBtn();

        DisplayField displayField = new DisplayField(getDriver());
        Assert.assertEquals(displayField.getResultFieldText(), "1920", "Incorrect result");
    }

    @Test()
    public void testDivideOperation(){

        NumberPad numberPad = new NumberPad(getDriver());
        numberPad.tapDigitOnPad("1024");

        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapDivideBtn();
        numberPad.tapDigitOnPad("64");
        operatorPad.tapEqualsBtn();

        DisplayField displayField = new DisplayField(getDriver());
        Assert.assertEquals(displayField.getResultFieldText(), "16", "Incorrect result");
    }

}
