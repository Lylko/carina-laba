package com.qaprosoft.carina.demo.gui.pages.amazon;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class loginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id = 'ap_email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@id = 'ap_password']")
    private ExtendedWebElement passField;

    @FindBy(xpath = "//span[contains(text(),'email address')]")
    private ExtendedWebElement notFoundMail;

    @FindBy(xpath = "//input[@id = 'continue']")
    private ExtendedWebElement continueBtn;

    @FindBy(xpath = "//input[@id='signInSubmit']")
    private ExtendedWebElement signBtn;

    public loginPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getEmailField(){
        return this.emailField;
    }

    public ExtendedWebElement getPassField(){
        return this.passField;
    }

    public ExtendedWebElement getContinueBtn(){
        return this.continueBtn;
    }

    public ExtendedWebElement getSignBtn(){
        return this.signBtn;
    }

    public String getNotFoundMail(){
        return this.notFoundMail.getText();
    }
}
