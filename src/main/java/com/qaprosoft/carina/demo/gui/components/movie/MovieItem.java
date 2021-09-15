package com.qaprosoft.carina.demo.gui.components.movie;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MovieItem extends AbstractUIObject {

    @FindBy(xpath = ".")
    private ExtendedWebElement movieItemLink;

    @FindBy(xpath = ".//h1")
    private ExtendedWebElement movieName;

    @FindBy(xpath = ".//button[@aria-label = 'Remove Season from Watchlist' or @aria-label = 'Remove from Watchlist']")
    private ExtendedWebElement removeMovieBtn;

    public MovieItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void openMoviePage(){
        movieItemLink.click();
    }

    public void removeMovieFromWatchList(){
        removeMovieBtn.click();
    }

    public String getMovieName(){
        movieItemLink.hover();
        return movieName.getText();
    }

}
