package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by PTeledzinski
 */
public class HomePage {

    final WebDriver driver;

    @FindBy(css = "#brick-43 > div > div.cookiebar__button-container > span")
    public static WebElement cookies;

    @FindBy(css = "body > header > div.header__container > div > div.header__column--home > a > img")
    public static WebElement logo;

    @FindBy(css = "#navigation > ul > li:nth-child(2) > a")
    public static WebElement businessValue;

    @FindBy(css = "#navigation > ul > li:nth-child(2) > div > ul > div:nth-child(3) > div:nth-child(2) > a")
    public static WebElement eu_GDPR;

    @FindBy(css = "#brick-2466 > div > div > div:nth-child(1) > div > img")
    public static WebElement ue_Flag_img ;


    @FindBy(css = "#brick-776 > div > div > div:nth-child(2) > section > h1")
    public static WebElement eight_steps ;

    @FindBy(css = "#brick-776 > div > div > div:nth-child(2) > section > a")
    public static WebElement download ;

    @FindBy(css = "#brick-2541 > div > h1")
    public static WebElement headerEU ;





    public HomePage(WebDriver driver){

        this.driver = driver;
    }

}
