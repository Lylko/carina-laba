package com.qaprosoft.carina.demo.mobile.gui.components.calculator;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OperatorPad extends AbstractUIObject {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='delete']")
    private ExtendedWebElement deleteBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='divide']")
    private ExtendedWebElement divideBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='×']")
    private ExtendedWebElement multiplyBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='minus']")
    private ExtendedWebElement minusBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='plus']")
    private ExtendedWebElement plusBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='equals']")
    private ExtendedWebElement equalsBtn;

    public OperatorPad(WebDriver driver) {
        super(driver);
    }

    public void tapDeleteBtn(){
        deleteBtn.click();
    }

    public void tapDivideBtn(){
        divideBtn.click();
    }

    public void tapMultiplyBtn(){
        multiplyBtn.click();
    }

    public void tapMinusBtn(){
        minusBtn.click();
    }

    public void tapPlusBtn(){
        plusBtn.click();
    }

    public void tapEqualsBtn(){
        equalsBtn.click();
    }
}
