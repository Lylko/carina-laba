package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'Account & Lists')]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//a[@id='icp-nav-flyout']")
    private ExtendedWebElement changeLangBtn;

    @FindBy(xpath = "//span[contains(text(),'Hello, ') or contains(text(),'Hallo, ')]")
    private ExtendedWebElement helloText;

    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    private ExtendedWebElement signOutBtn;

    @FindBy(xpath = "//span[@class='nav-text' and contains(text(),'Deutsch')]")
    private ExtendedWebElement deutschLangBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public String getHelloText(){
        return helloText.getText();
    }

    public ExtendedWebElement getLoginBtn(){
        return loginBtn;
    }

    public ExtendedWebElement getChangeLangBtn(){
        return changeLangBtn;
    }

    public ExtendedWebElement getSignOutBtn(){
        return signOutBtn;
    }

    public ExtendedWebElement getDeutschLangBtn(){
        return deutschLangBtn;
    }
}
