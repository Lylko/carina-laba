package com.qaprosoft.carina.demo.mobile.gui.pages.avto.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OptionsPage extends AbstractPage {

    @FindBy(xpath = "//android.widget.ToggleButton[@text = 'Все']")
    private ExtendedWebElement allCarsBtn;

    @FindBy(xpath = "//android.widget.ToggleButton[@text = 'Новые']")
    private ExtendedWebElement newCarsBtn;

    @FindBy(xpath = "//android.widget.ToggleButton[@text = 'С пробегом']")
    private ExtendedWebElement usedCarsBtn;

    @FindBy(id = "do_search_btn")
    private ExtendedWebElement searchBtn;

    @FindBy(id = "btn_clear")
    private ExtendedWebElement clearLocationBtn;

    public OptionsPage(WebDriver driver) {
        super(driver);
    }

    public void chooseNewCars(){
        newCarsBtn.click();
    }

    public void chooseUsedCars(){
        usedCarsBtn.click();
    }

    public void tapSearchBtn(){
        searchBtn.click();
    }

    public void tapClearLocationBtn(){
        clearLocationBtn.click();
    }


}
