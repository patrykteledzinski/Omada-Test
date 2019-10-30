package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by PTeledzinski on 05.11.2018.
 */
public class TemplatePOP {

    final WebDriver driver;

    @FindBy(css = "body > div.main-wrapper > div.fee54_36lM3.headroom--top.headroom--not-bottom > nav > div.opbox-metrum-header__center.fee54_2LIih.fee54_1Wk4P.fee54_1wDui._1sd8w._g1a3g._1bwbg > div.fee54_3ms7P.opbox-metrum-header__search-slot > div > form > input")
    public static WebElement searchField;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div/div/button/i")
    public static WebElement crossButton;

    @FindBy(xpath = "/html/body/div[4]/div/div[2]/div/div/div/h3")
    public static WebElement klient;




    public TemplatePOP(WebDriver driver){

        this.driver = driver;
    }

}
