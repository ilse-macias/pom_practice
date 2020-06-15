package tests;

import settings.DriverSetup;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class SimpleTest {

    @Test
    public void verifyPricesSortingIsWorking(){
        WebDriver driver = new DriverSetup("chrome", false).getDriver();
        driver.get("https://www.expedia.mx");
    }
}
