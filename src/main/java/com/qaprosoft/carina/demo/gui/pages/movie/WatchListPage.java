package com.qaprosoft.carina.demo.gui.pages.movie;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.movie.MovieItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchListPage extends AbstractPage {

    @FindBy(xpath = "//div[@class = 'av-hover-wrapper']")
    private List<MovieItem> movies;

    @FindBy(xpath = "//div[@data-automation-id='mystuff-watchlist']//a[contains(text(),'Movies')]")
    private ExtendedWebElement movieCategoryBtn;

    @FindBy(xpath = "//div[@class = 'av-retail-m-nav-lists']//a[contains(text(), 'Store')]")
    private ExtendedWebElement storeNavBtn;

    @FindBy(xpath = "//div[@data-automation-id='mystuff-watchlist']//a[contains(text(), 'All')]")
    private ExtendedWebElement allMoviesFilterBtn;

    public WatchListPage(WebDriver driver) {
        super(driver);
    }

    public List<MovieItem> getListOfMovies(){
        return movies;
    }

    public void chooseMovieCategory(){
        movieCategoryBtn.click();
    }

    public void openStore(){
        storeNavBtn.click();
    }

    public void openAllMovies(){
        allMoviesFilterBtn.click();
    }



}
