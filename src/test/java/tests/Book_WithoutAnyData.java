package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.ExampleHotelPage;

import java.util.List;
import java.util.Random;

public class Book_WithoutAnyData {
    public WebDriver driver;
    private String baseUrl;


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

    @Test
    public void Test () {

        //Step 1. Open hotel page and close cookie warning
        driver.get(baseUrl);
        ExampleHotelPage.cookie.click();

        //Assertion 1. Check the Page Title
        String HomePage = driver.getTitle();
        System.out.println("ExampleHotelPage Title: "+HomePage);
        assert HomePage.contentEquals("Hotels Booking Checkout");

        //Step 2. Click on "Complete Booking" button
        Actions actions = new Actions(driver);
        actions.moveToElement(ExampleHotelPage.completeBookingButton);
        actions.perform();
        ExampleHotelPage.completeBookingButton.click();
    }

    @AfterTest
    public void teardown () {
        //driver.quit();
    }
}