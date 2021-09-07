package com.qaprosoft.carina.demo.mobile.gui.components.avto;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class OfferItem extends AbstractUIObject implements IMobileUtils {

    public OfferItem(WebDriver driver) {
        super(driver);
    }

}
