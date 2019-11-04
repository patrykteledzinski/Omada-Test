package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


/**
 * Created by PTeledzinski
 */
public class ExampleHotelPage {

    final WebDriver driver;

    // Booking Information section

    @FindBy(css = "#title > option")
    public static List<WebElement> titleList;

    @FindBy(id = "first_name")
    public static WebElement firstNameField;

    @FindBy(id = "last_name")
    public static WebElement lastNameField;

    @FindBy(css = "#thhotels > div > div.col-md-8.mt-30 > div:nth-child(3) > form > div.panel.panel-primary.guest > div.panel-body > div:nth-child(2) > div:nth-child(2) > input")
    public static WebElement emailField;

    @FindBy(css = "#country_code_chosen > div > ul > li")
    public static List<WebElement> countryList;

    @FindBy(id = "country_code_chosen")
    public static WebElement countryButton;

    @FindBy(id = "phone_number")
    public static WebElement phoneField;

    // Payments Details section

    @FindBy(id = "cardHolderName")
    public static WebElement cardNameField;

    @FindBy(id = "cardNumber")
    public static WebElement cardNumberField;

    @FindBy(css = "#month > option")
    public static List<WebElement> expirationDateMonthList;

    @FindBy(css = "#thhotels > div > div.col-md-8.mt-30 > div:nth-child(3) > form > div.panel.panel-default.guest > div.panel-body > div.row.credit-card__form-container > div.col-md-7 > div:nth-child(3) > div.col-md-4.mb-20 > select > option")
    public static List<WebElement> expirationDateYearList;

    @FindBy(id = "cardCVC")
    public static WebElement securityCode;

    @FindBy(id = "completeBooking")
    public static WebElement completeBookingButton;

    @FindBy(css = "#cookyGotItBtnBox>div")
    public static WebElement cookie;


    public ExampleHotelPage(WebDriver driver){

        this.driver = driver;
    }

}
