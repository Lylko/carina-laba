package com.qaprosoft.carina.demo.amazon;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.components.NavigationTools;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.movie.MovieStorePage;
import com.qaprosoft.carina.demo.gui.pages.movie.WatchListPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WatchListTest implements IAbstractTest {



    @BeforeMethod()
    public void login(){

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.tapLoginBtn();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.makeLogin();

        Assert.assertFalse(home.getHelloText().contains("Sign in"), "User not authorised");

    }

    @AfterTest()
    public void deleteWatchListChanges(){
        login();

        NavigationTools navigationTools = new NavigationTools(getDriver());
        navigationTools.openWatchListPage();
        WatchListPage watchListPage = new WatchListPage(getDriver());
        watchListPage.openAllMovies();
        int prevCount = watchListPage.getListOfMovies().size();
        watchListPage.getListOfMovies().get(0).removeMovieFromWatchList();

        navigationTools.openWatchListPage();
        watchListPage.openAllMovies();
        Assert.assertTrue(watchListPage.getListOfMovies().size() < prevCount, "Count is incorrect!");
    }

    @Test()
    public void testAddingToWatchList(){

        NavigationTools navigationTools = new NavigationTools(getDriver());

        navigationTools.openWatchListPage();

        WatchListPage watchListPage = new WatchListPage(getDriver());
        watchListPage.openAllMovies();
        int prevCount = watchListPage.getListOfMovies().size();
        watchListPage.openStore();

        MovieStorePage movieStorePage = new MovieStorePage(getDriver());
        movieStorePage.getMoviesByContainerName("Prime Member Deals").getMovieList().get(2).addToWatchList();

        navigationTools.openWatchListPage();
        watchListPage.openAllMovies();

        Assert.assertTrue(watchListPage.getListOfMovies().size() > prevCount, "Count is incorrect!");

    }

}
