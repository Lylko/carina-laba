package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, \"s-result-item\") and not(contains(@class, \"AdHolder\")) and" +
            " @data-component-type != \"\"]")
    private List<SearchItem> searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<SearchItem> getSearchItems() {
        return searchItems;
    }
}
