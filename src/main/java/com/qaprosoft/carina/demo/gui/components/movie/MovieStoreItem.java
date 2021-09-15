package com.qaprosoft.carina.demo.gui.components.movie;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MovieStoreItem extends AbstractUIObject {

    @FindBy(xpath = ".//button[@aria-label = 'Add Season to Watchlist' or @aria-label = 'Add to Watchlist']")
    private ExtendedWebElement addToWatchListBtn;

    @FindBy(xpath = ".")
    private ExtendedWebElement linkToMovie;

    public MovieStoreItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void addToWatchList(){
        linkToMovie.hover();
        addToWatchListBtn.click();
    }
}
