package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import pages.HomePage;
import pages.Portal2Page;
import pages.SearchGameListPage;
import settings.BaseTest;
import components.NavBar;

import java.util.ArrayList;

public class HomePageTests extends BaseTest {

    private NavBar navBar;
    private HomePage homePage;
    private SearchGameListPage searchGame;
    private Portal2Page portal2;

    @BeforeTest
    public void setUp(){
        navBar = new NavBar(this.driver);
        homePage = new HomePage(this.driver);
        searchGame = new SearchGameListPage(this.driver);
        portal2 = new Portal2Page(this.driver);
    }

    @Test
    public void openAllNavBarTabs(){
        navBar.openYourStoreTab();
        navBar.openGamesTab();
    }

    @Test
    public void testSuggestedGames() throws InterruptedException {
        String game_name = "Portal";
        navBar.writeGameIntoSearchInput(game_name);

        ArrayList<String> games = navBar.getSuggestedGames();
        Assert.assertTrue(games.size() == 5, "The number of suggested games is not correct");
        for(String game: games){
            Assert.assertTrue(game.indexOf("Portal") >= 0, "The game " + game + " is not correct. Not contains Search String " + game_name);
        }

        homePage.clickOnMagnifyingGlassIcon();
        searchGame.clickOnTheGameDesired();
        portal2.ValidateTheGame();
    }

}

