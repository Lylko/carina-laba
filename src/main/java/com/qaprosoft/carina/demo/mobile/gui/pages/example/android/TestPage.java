package com.qaprosoft.carina.demo.mobile.gui.pages.example.android;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TestPage extends AbstractPage {
    public TestPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://amazon.com");
    }

}
