package com.qaprosoft.carina.demo.mobile.gui.pages.calculator.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.common.HistoryPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HistoryPage extends HistoryPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text = 'No History']")
    private ExtendedWebElement noHistoryText;

    @FindBy(id = "history_result")
    private ExtendedWebElement historyResult;

    @FindBy(id = "history_toolbar")
    ExtendedWebElement historyToolbar;

    @FindBy(id = "history_formula_container")
    private ExtendedWebElement historyFormula;

    public HistoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened(){
        return noHistoryText.isPresent();
    }

    public String getHistoryResultText(){
        return historyResult.getText();
    }
}
