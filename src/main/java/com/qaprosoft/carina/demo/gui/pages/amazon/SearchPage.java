package com.qaprosoft.carina.demo.gui.pages.amazon;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.amazon.SearchItem;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, \"s-result-item\")]")
    private List<SearchItem> searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<SearchItem> getAvailableForBuyItems(){
        List<SearchItem> availableItems = new ArrayList<>();
        for (SearchItem item : searchItems){
            if (item.getItemPrice() != null){
                availableItems.add(item);
            }
        }
        return availableItems;
    }

    public List<SearchItem> getSearchItems() {
        return this.searchItems;
    }
}
