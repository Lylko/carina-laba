package com.qaprosoft.carina.demo.mobile.gui.pages.calculator.android;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.common.HomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private ExtendedWebElement settingBtn;

    @FindBy(xpath = "//android.widget.TextView[@text = 'History']")
    private ExtendedWebElement historyBtn;

    @FindBy(id = "display")
    private ExtendedWebElement displayField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void tapSettingBtn(){
        settingBtn.click();
    }

    public void openHistory(){
        settingBtn.click();
        historyBtn.click();
    }

    public void openHistoryBySwipe(){
        HistoryPage historyPage = new HistoryPage(getDriver());
        swipe(historyPage.historyToolbar, Direction.DOWN);
    }

}
