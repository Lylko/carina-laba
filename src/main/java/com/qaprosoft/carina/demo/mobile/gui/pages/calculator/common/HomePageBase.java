package com.qaprosoft.carina.demo.mobile.gui.pages.calculator.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void tapSettingBtn();

    public abstract void openHistory();

    public abstract void tapDigitOnPad(String s);

    public abstract void tapDeleteBtn();

    public abstract String getFormula();

    public abstract void tapPlusBtn();

    public abstract void tapEqualsBtn();

    public abstract String getResultFieldText();

    public abstract void tapMinusBtn();

    public abstract void tapMultiplyBtn();

    public abstract void tapDivideBtn();

    public abstract void openHistoryBySwipe();
}
