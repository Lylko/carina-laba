package com.qaprosoft.carina.demo.mobile.gui.pages.avto.android;

import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.mobile.gui.components.avto.OfferItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OfferPage extends AbstractPage implements IMobileUtils {

    public OfferPage(WebDriver driver) {
        super(driver);
    }

//    public void showAllCarNames(){
//        HashMap<String, WebElement> offerItemMap = new HashMap<>();
//        while (offerItemMap.size() < 3){
//            swipeUp(300);
//            offerItemMap.put(getDriver().findElement(By.xpath("//android.view.ViewGroup[@resource-id = " +
//                    "'ru.auto.ara:id/snippetContainer']")).getText(), );
//        }
//    }
}
