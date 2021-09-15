package com.qaprosoft.carina.demo.gui.pages.movie;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.movie.MovieStoreList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class MovieStorePage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'min-width-collection')]")
    private List<MovieStoreList> movieContainerList;

    @FindBy(xpath = "//div[contains(@class, 'min-width-collection')]//h2")
    private List<ExtendedWebElement> containerNameList;


    public MovieStorePage(WebDriver driver) {
        super(driver);
    }

    public MovieStoreList getMoviesByContainerName(String name){
        List<String> list = containerNameList.stream().map((s) -> s.getText()).collect(Collectors.toList());
        return movieContainerList.get(list.indexOf(name));
    }
}
