package pages;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import settings.BasePage;
import java.util.List;
import java.util.ArrayList;

public class Portal2Page extends BasePage {

    @FindBy(className = "apphub_HeaderStandardTop")
   // private List<WebElement> gameName;
    private WebElement gameName;

    @FindBy(linkText = "Portal 2 on Steam")
    private String textGameName;

    public Portal2Page(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void ValidateTheGame() {
        // driver.findElement(By.linkText(textGameName)).getText();
        String currentUrlGame = driver.getCurrentUrl();


        if (currentUrlGame.contains("https://store.steampowered.com/app/")) {
            System.out.println("The page is valid: " + currentUrlGame);
            Assert.assertEquals(currentUrlGame, "https://store.steampowered.com/app/620/Portal_2/");
        }

        String content = driver.getTitle();
        if (content.contains("Portal") && gameName.getText().contains("Portal"))
            System.out.println(gameName.getText() + " AND " + content);
        }
    }
