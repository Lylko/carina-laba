package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getEmailField(){
        return emailField;
    }

    public ExtendedWebElement getPassField(){
        return passField;
    }

    public ExtendedWebElement getContinueBtn(){
        return continueBtn;
    }

    public ExtendedWebElement getSignBtn(){
        return signBtn;
    }

    public String getNotFoundMail(){
        return notFoundMail.getText();
    }

    public void makeLogin(){
        getEmailField().type(R.TESTDATA.get("login"));
        getContinueBtn().click();
        getPassField().type(R.TESTDATA.get("password"));
        getSignBtn().click();
    }

}
