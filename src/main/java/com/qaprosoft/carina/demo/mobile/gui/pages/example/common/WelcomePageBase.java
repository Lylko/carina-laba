package com.qaprosoft.carina.demo.mobile.gui.pages.example.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract LoginPageBase clickNextBtn();

}
