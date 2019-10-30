package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObjects.TemplatePOP;

public class Test<baseUrl> {
    public WebDriver driver;
    public WebDriverWait wait;
    private String baseUrl;
    public WebDriver getDriver() { return driver;
    }

    @BeforeTest
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();

        //Create a wait. All test classes use this.
        wait = new WebDriverWait(driver,15);

        //Clean cookies
        driver.manage().deleteAllCookies();

        //Maximize Window
        driver.manage().window().maximize();

        //URL address
        baseUrl = "http://www.omada.net";

        PageFactory.initElements(driver, TemplatePOP.class);
    }

    @org.testng.annotations.Test
    public void Test () {

        //Main Page
        driver.get(baseUrl);
        //TemplatePOP.crossButton.click();

    }

    @AfterTest
    public void teardown () {
        driver.quit();
    }
}