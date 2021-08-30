package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.commons.SpecialKeywords;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Pattern;

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

    public void typeLogin(String login){
        emailField.type(login);
    }

    public void typePassword(String password){
        passField.type(password);
    }

    public void tapContinueBtn(){
        continueBtn.click();
    }

    public void tapSignBtn(){
        signBtn.click();
    }

    public String getNotFoundMailText(){
        return notFoundMail.getText();
    }

    public void makeLogin(){

        CryptoTool cryptoTool = new CryptoTool("/Users/iandrosau/Documents/crypto.key");
        Pattern CRYPTO_PATTERN = Pattern.compile(SpecialKeywords.CRYPT);

        typeLogin(cryptoTool.decryptByPattern(R.TESTDATA.get("login"), CRYPTO_PATTERN).
                replaceAll("\"", ""));
        tapContinueBtn();
        typePassword(cryptoTool.decryptByPattern(R.TESTDATA.get("password"), CRYPTO_PATTERN).
                replaceAll("\"", ""));
        tapSignBtn();
    }

}
