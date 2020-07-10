package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;

public class Portal2Page extends BasePage {

    @FindBy(linkText = "Portal 2")
    private WebElement gameOption;

    public Portal2Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void CompareTitle(){
        this.click(gameOption);
    }
}
