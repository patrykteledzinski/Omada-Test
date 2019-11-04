package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


/**
 * Created by PTeledzinski
 */
public class LoginPage {

    final WebDriver driver;

    @FindBy(css = "#toggleStyle04-collapseOne > div > div > div.wow.fadeIn > div > div:nth-child(1) > input")
    public static WebElement login;

    @FindBy(css = "#toggleStyle04-collapseOne > div > div > div.wow.fadeIn > div > div:nth-child(2) > input")
    public static WebElement password;

    @FindBy(css = "#loginfrm > button")
    public static WebElement loginSubmit;

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

}
