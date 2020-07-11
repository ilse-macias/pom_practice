package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;

public class SearchGameListPage extends BasePage {

    @FindBy(xpath = "/html/body/div[1]/div[7]/div[4]/div/div[2]/div[2]/a/img[2]")
    private WebElement bannerSearchFunction;

    @FindBy(xpath = "//*[@id='search_resultsRows']/a[1]/div[1]/img")
    private WebElement gameOption;

    public SearchGameListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnTheGameDesired() {
        this.click(gameOption);
        //Here I can do a for cycle. class="col search_capsule"


    }
}
