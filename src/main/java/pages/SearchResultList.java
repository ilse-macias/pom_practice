package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultList extends HomePage {

    @FindBy(linkText = "Portal 2")
    private WebElement selectedGameUrl;

    @FindBy(id = "searchterm_options")
    private WebElement resultList;

    public SearchResultList(WebDriver driver) {
        super(driver);
    }

    public void ClickOnTheGame(){
        this.hoverElement(resultList);
        this.click(selectedGameUrl);
    }
}
