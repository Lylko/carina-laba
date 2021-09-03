package com.qaprosoft.carina.demo.mobile.gui.components.calculator;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DisplayField extends AbstractUIObject {

    @FindBy(id = "result_final")
    private ExtendedWebElement resultField;

    public DisplayField(WebDriver driver) {
        super(driver);
    }

    public String getResultFieldText(){
        return resultField.getText();
    }
}
