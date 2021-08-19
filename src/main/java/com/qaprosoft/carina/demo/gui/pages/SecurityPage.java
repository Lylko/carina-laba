package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SecurityPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(), 'Edit')]/preceding-sibling::input[contains(@id, 'name-button')]")
    private ExtendedWebElement editNameBtn;

    @FindBy(xpath = "//input[@id = 'ap_customer_name']")
    private ExtendedWebElement changeNameField;

    @FindBy(xpath = "//input[@class = 'a-button-input']")
    private ExtendedWebElement saveBtn;

    public SecurityPage(WebDriver driver) {
        super(driver);
    }

    public void tapEditNameBtn() {
        editNameBtn.click();
    }

    public void typeName(String name) {
        changeNameField.type(name);
    }

    public void tapSaveBtn() {
        saveBtn.click();
    }
}
