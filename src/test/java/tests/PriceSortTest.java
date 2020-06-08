package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import pages.HomePage;
import pages.ResultsPage;
import settings.DriverSetup;
import settings.WaitingTimeSetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class PriceSortTest {

    private WebDriver driver;
    private Logger logger;
    private String travelFromCity;
    private String travelToCity;
    private String strDepartureDate;
    private String strReturnDate;

    private HomePage homePage;
    private ResultsPage resultsPage;

    @BeforeClass
    public void setTest() {
        driver = new DriverSetup("chrome", false).getDriver();
        logger = LogManager.getLogger(this);
        homePage = new HomePage(driver);
        resultsPage = new ResultsPage(driver);
        driver.get("https://www.expedia.mx");
        logger.trace("Home Page loaded, beginning test.");
        travelFromCity = "SFO";
        travelToCity = "LAS";

        Calendar departureDate = Calendar.getInstance();
        departureDate.add(Calendar.DATE, 3);

        Calendar returnDate = Calendar.getInstance();
        departureDate.add(Calendar.DATE, 6);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        strDepartureDate = dateFormat.format(departureDate.getTime());
        strReturnDate = dateFormat.format(returnDate.getTime());
    }

    @Test
    public void verifyPricesSortingIsWorking()   {
        logger.debug("Sending search criteria to required fields");
        homePage.getFlightsButton().click();
        homePage.getCityComingFromField().sendKeys(travelFromCity);
        homePage.getCityHeadingToField().click();
        homePage.getCityHeadingToField().sendKeys(travelToCity);
        homePage.getDepartureDateField().sendKeys(strDepartureDate);

        for(int i = 0; i < 10; i++){
            homePage.getReturnDateField().sendKeys(Keys.BACK_SPACE);
        }

        homePage.getReturnDateField().sendKeys(strReturnDate);
        homePage.getSearchButton().click();

        new WebDriverWait(driver, WaitingTimeSetup.getTimeForWebElement()).
                until(ExpectedConditions.visibilityOfAllElements(resultsPage.getFlightPrices()));

        ArrayList<Integer> expectedPricesSorted = resultsPage.getPrices();
        Collections.reverse(expectedPricesSorted);
        new Select(resultsPage.getSortDropdownButton()).selectByValue("price:desc");

        new WebDriverWait(driver, WaitingTimeSetup.getTimeForWebElement()).
                until(ExpectedConditions.elementToBeClickable(resultsPage.getSortDropdownButton()));

        List<Integer> sortedPrices = resultsPage.getPrices();

        Assert.assertEquals(expectedPricesSorted, sortedPrices, "Price sorting did not worked as expected");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
