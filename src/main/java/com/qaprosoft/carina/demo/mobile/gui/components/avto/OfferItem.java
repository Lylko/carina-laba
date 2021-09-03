package com.qaprosoft.carina.demo.mobile.gui.components.avto;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OfferItem extends AbstractUIObject {

    @FindBy(xpath = "//android.view.ViewGroup[@index = 2]")
    private ExtendedWebElement offerItem;

    @FindBy(xpath = "//android.widget.TextView[@resource-id = 'ru.auto.ara:id/title']")
    private ExtendedWebElement offerText;

    @FindBy(id = "promo_filter_title")
    private ExtendedWebElement promoTitle;

    public OfferItem(WebDriver driver) {
        super(driver);
    }

    public String getCarName(){
        return offerText.getText();
    }
}
