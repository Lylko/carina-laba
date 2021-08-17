package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = "//h2[contains(text(), \"Login & security\")]/ancestor::a")
    private ExtendedWebElement loginAndSecurityBtn;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageURL("/gp/css/homepage.html?ref_=nav_AccountFlyout_ya");
    }

    public ExtendedWebElement getLoginAndSecurityBtn() {
        return loginAndSecurityBtn;
    }
}
