package com.qaprosoft.carina.demo.mobile.gui.components.calculator;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NumberPad extends AbstractUIObject {

    @FindBy(xpath = "//android.widget.Button[@content-desc='point']")
    private ExtendedWebElement pointBtn;

    public NumberPad(WebDriver driver) {
        super(driver);
    }

    public void tapDigitOnPad(String digit){
        WebElement digitBtn = getDriver().findElement(By.id("com.google.android.calculator:id/digit_" + digit));
        digitBtn.click();
    }

    public void tapPointBtn(){
        pointBtn.click();
    }
}
