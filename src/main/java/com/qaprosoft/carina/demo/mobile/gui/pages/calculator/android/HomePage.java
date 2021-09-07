package com.qaprosoft.carina.demo.mobile.gui.pages.calculator.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.calculator.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.example.common.WelcomePageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    private ExtendedWebElement settingBtn;

    @FindBy(xpath = "//android.widget.TextView[@text = 'History']")
    private ExtendedWebElement historyBtn;

    @FindBy(id = "result_final")
    private ExtendedWebElement resultField;

    @FindBy(id = "formula")
    private ExtendedWebElement formulaField;

    @FindBy(id = "display")
    private ExtendedWebElement displayField;

    @FindBy(xpath = "//android.widget.Button[@content-desc='point']")
    private ExtendedWebElement pointBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='delete']")
    private ExtendedWebElement deleteBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='divide']")
    private ExtendedWebElement divideBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='×']")
    private ExtendedWebElement multiplyBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='minus']")
    private ExtendedWebElement minusBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='plus']")
    private ExtendedWebElement plusBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='equals']")
    private ExtendedWebElement equalsBtn;

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

    public String getResultFieldText(){
        return resultField.getText();
    }

    public String getFormula(){
        return formulaField.getText();
    }

    public void tapDigitOnPad(String digit){

        List<String> digitList = List.of(digit.split(""));
        if (digitList.size() == 1){
            WebElement digitBtn = getDriver().findElement(By.id("digit_" + digit));
            digitBtn.click();
        } else {
            for (String dig : digitList){
                WebElement digitBtn = getDriver().findElement(By.id("digit_" + dig));
                digitBtn.click();
            }
        }
    }

    public void tapPointBtn(){
        pointBtn.click();
    }

    public void tapDeleteBtn(){
        deleteBtn.click();
    }

    public void tapDivideBtn(){
        divideBtn.click();
    }

    public void tapMultiplyBtn(){
        multiplyBtn.click();
    }

    public void tapMinusBtn(){
        minusBtn.click();
    }

    public void tapPlusBtn(){
        plusBtn.click();
    }

    public void tapEqualsBtn(){
        equalsBtn.click();
    }

}
