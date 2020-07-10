package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import settings.BasePage;

public class SearchGameListPage extends BasePage {

    @FindBy(xpath = "//*[@id='search_resultsRows']/a[1]/div[1]/img")
    private WebElement gameOption;

    public SearchGameListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnTheGameDesired(){
        this.click(gameOption);
    }
}
