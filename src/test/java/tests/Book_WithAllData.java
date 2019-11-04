package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObjects.ExampleHotelPage;
import java.util.List;
import java.util.Random;

public class Book_WithAllData {
    public WebDriver driver;
    private String baseUrl;

    //Data
    String First_Name = "Adam";
    String Last_Name = "Kowalski";
    String Email = "JKowalski@niepodam.pl";
    String Phone = "777777777";
    String CardName = "Visa";
    String CardNumber = "4111111111111111";
    String SecurityCode = "1234";

    @BeforeTest
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
        //Clean cookies
        driver.manage().deleteAllCookies();
        //Maximize Window
        driver.manage().window().maximize();
        //URL address
        baseUrl = "https://www.phptravels.net/thhotels/checkout/Ambassador%20Bangkok%20Hotels";
        //Page Object Model
        PageFactory.initElements(driver, ExampleHotelPage.class);
    }

    @org.testng.annotations.Test
    public void Test () {

        //Step 1. Open hotel page
        driver.get(baseUrl);

        //Assertion 1. Check the Page Title
        String HomePage = driver.getTitle();
        System.out.println("ExampleHotelPage Title: "+HomePage);
        assert HomePage.contentEquals("Hotels Booking Checkout");

        //Step 2. Select random "Title" in dropdownlist
        List<WebElement> options = ExampleHotelPage.titleList;
        Random rand = new Random();
        int list= rand.nextInt(options.size());
        options.get(list).click();

        //Step 3. Type in "First Name" Tip: For example "Adam"
        ExampleHotelPage.firstNameField.sendKeys(First_Name);

        //Step 4. Type in "Last Name" Tip: For example "Kowalski"
        ExampleHotelPage.lastNameField.sendKeys(Last_Name);

        //Step 5. Type in "Email"
        ExampleHotelPage.emailField.sendKeys(Email);

        //Step 6. Select random "Country" in dropdownlist
        ExampleHotelPage.countryButton.click();
        List<WebElement> options2 = ExampleHotelPage.countryList;
        Random rand2 = new Random();
        int list2= rand2.nextInt(options.size());
        options2.get(list2).click();

        //Step 7. Type in "Phone"
        ExampleHotelPage.phoneField.sendKeys(Phone);

        //Step 8. Type in "Name on card*"
        ExampleHotelPage.cardNameField.sendKeys(CardName);

        //Step 9. Type in "Card Number*"
        ExampleHotelPage.cardNumberField.sendKeys(CardNumber);

        //Step 10. Select  "Expiration Date*" Tip: Only future date should be valid
        //Month
        List<WebElement> options3 = ExampleHotelPage.expirationDateMonthList;
        Random rand3 = new Random();
        int list3= rand3.nextInt(options.size());
        options3.get(list3).click();
        //Year
        List<WebElement> options4 = ExampleHotelPage.expirationDateYearList;
        Random rand4 = new Random();
        int list4= rand4.nextInt(options.size());
        options4.get(list4).click();

        //Step 11. Type in "Security code*"
        ExampleHotelPage.securityCode.sendKeys(SecurityCode);

        //Step 12. Click on "Complete Booking" button
        Actions actions = new Actions(driver);
        actions.moveToElement(ExampleHotelPage.completeBookingButton);
        actions.perform();
        ExampleHotelPage.completeBookingButton.click();

        //Assertion 2. Test should have at least assertion on the end of booking process. But that test application do not allow to that.
        //String ThankYouPage = driver.getTitle();
        //System.out.println("ThankYouPage after booking: "+ThankYouPage);
        //assert ThankYouPage.contentEquals("Thank You Page for Hotels Booking");
    }

    @AfterTest
    public void teardown () {
        driver.quit();
    }
}