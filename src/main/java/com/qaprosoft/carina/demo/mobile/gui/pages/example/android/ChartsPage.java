package com.qaprosoft.carina.demo.mobile.gui.pages.example.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.mobile.gui.pages.example.common.ChartsPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ChartsPageBase.class)
public class ChartsPage extends ChartsPageBase {

    public ChartsPage(WebDriver driver) {
        super(driver);
    }

}
