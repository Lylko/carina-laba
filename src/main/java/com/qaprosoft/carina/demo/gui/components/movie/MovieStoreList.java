package com.qaprosoft.carina.demo.gui.components.movie;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MovieStoreList extends AbstractUIObject {

    @FindBy(xpath = ".//div[contains(@class, 'tst-title-card')]")
    private List<MovieStoreItem> movieList;

    @FindBy(xpath = ".//h2")
    private ExtendedWebElement containerName;

    public MovieStoreList(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<MovieStoreItem> getMovieList(){
        return movieList;
    }

    public String getContainerName(){
        return containerName.getText();
    }
}
