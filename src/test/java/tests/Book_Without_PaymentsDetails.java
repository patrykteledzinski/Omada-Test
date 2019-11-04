package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ExampleHotelPage;

import java.util.List;
import java.util.Random;

public class Book_Without_PaymentsDetails {
    public WebDriver driver;
    private String baseUrl;

    //Data
    String First_Name = "Adam";
    String Last_Name = "Kowalski";
    String Email = "JKowalski@niepodam.pl";
    String Phone = "777777777";

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
        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 10);


    }

    @Test
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

        //Step 8. Click on "Complete Booking" button
        Actions actions = new Actions(driver);
        actions.moveToElement(ExampleHotelPage.completeBookingButton);
        actions.perform();
        ExampleHotelPage.completeBookingButton.click();
    }

    @AfterTest
    public void teardown () {
        driver.quit();
    }
}