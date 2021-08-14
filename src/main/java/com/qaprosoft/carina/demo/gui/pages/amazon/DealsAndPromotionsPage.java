package com.qaprosoft.carina.demo.gui.pages.amazon;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.amazon.DealsItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DealsAndPromotionsPage extends AbstractPage {

    @FindBy(xpath = "//span[@class = 'a-dropdown-container']")
    private ExtendedWebElement sortBtn;

    @FindBy(xpath = "//a[contains(text(), 'Price - High to Low')]")
    private ExtendedWebElement sortHighToLowBtn;

    @FindBy(xpath = "//b[contains(text(), \"Deals and Promotions\")]")
    private ExtendedWebElement pageName;

    @FindBy(xpath = "//div[contains(@id, \"dealView\")]")
    private List<DealsItem> listOfDeals;

    public DealsAndPromotionsPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getSortBtn(){
        return this.sortBtn;
    }

    public ExtendedWebElement getSortHighToLowBtn() {
        return this.sortHighToLowBtn;
    }

    public String getPageName() {
        return this.pageName.getText();
    }

    public List<DealsItem> getListOfDeals() {
        return listOfDeals;
    }

    public List<DealsItem> getOnlyAvailableDeals(){
        List<DealsItem> dealsItems = getListOfDeals();
        List<DealsItem> newList = new ArrayList<>();
        for (DealsItem item : dealsItems){
            if ("Add to Cart".equals(item.getAddToCartBtn().getText())){
                newList.add(item);
            }
        }
        return newList;
    }
}
