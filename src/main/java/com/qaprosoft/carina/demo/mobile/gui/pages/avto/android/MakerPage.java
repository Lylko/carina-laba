package com.qaprosoft.carina.demo.mobile.gui.pages.avto.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MakerPage extends AbstractPage {

    @FindBy(xpath = "//android.widget.RelativeLayout[@index > 0]")
    private List<ExtendedWebElement> testBtn;

    public MakerPage(WebDriver driver) {
        super(driver);
    }

    public void tapTestBtn(){
        testBtn.get(1).click();
    }
}
