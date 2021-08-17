package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LanguageSettingPage extends AbstractUIObject {

    @FindBy(xpath = "//span[contains(text(),'Deutsch')]")
    private ExtendedWebElement deutschLangBtn;

    @FindBy(xpath = "//span[@role = \"button\"]")
    private ExtendedWebElement changeCurrencyBtn;

    @FindBy(xpath = "//a[contains(text(),\"USD\")]")
    private ExtendedWebElement changeToUsdBtn;

    @FindBy(xpath = "//a[contains(text(),\"RUB\")]")
    private ExtendedWebElement changeToRubBtn;

    @FindBy(xpath = "//div[@id=\"customer-preferences\"]//input[@type = \"submit\"]")
    private ExtendedWebElement saveBtn;

    public LanguageSettingPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getDeutschLangBtn() {
        return deutschLangBtn;
    }

    public ExtendedWebElement getChangeCurrencyBtn() {
        return changeCurrencyBtn;
    }

    public ExtendedWebElement getChangeToUsdBtn() {
        return changeToUsdBtn;
    }

    public ExtendedWebElement getChangeToRubBtn() {
        return changeToRubBtn;
    }

    public ExtendedWebElement getSaveBtn() {
        return saveBtn;
    }
}
