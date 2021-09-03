package com.qaprosoft.carina.demo.mobile.gui.pages.avto.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.avto.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageBase {

    @FindBy(xpath = "//android.widget.TextView[@text = 'Марка и модель']")
    private ExtendedWebElement modelBtn;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Параметры']")
    private ExtendedWebElement optionsBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void tapModelBtn() {
        modelBtn.click();
    }

    public void tapOptionsBtn(){
        optionsBtn.click();
    }
}
