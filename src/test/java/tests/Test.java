package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pageObjects.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        PageFactory.initElements(driver, HomePage.class);
    }

    @org.testng.annotations.Test
    public void Test () throws InterruptedException {

        //Main Page
        driver.get(baseUrl);
        //Close cookies tab
       // HomePage.cookies.click();

        //Check the Page Title
        String HomePage = driver.getTitle();
        System.out.println("HomePage Title: "+HomePage);
        assert HomePage.contentEquals("Omada Home | Do More With Identity");

        //Check displayed of the Logo
        Boolean logo = pageObjects.HomePage.logo.isDisplayed();
        System.out.println("The logo is displayed: "+logo);
        assert logo.equals(true);

        //Focus on Business Value
        WebElement BV = pageObjects.HomePage.businessValue;
        WebElement eu_GDPR = pageObjects.HomePage.eu_GDPR;
        wait.until(ExpectedConditions.elementToBeClickable(BV));
        new Actions(driver).moveToElement(BV).perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#navigation > ul > li:nth-child(2) > div > ul > div:nth-child(3) > div:nth-child(2) > a")));

        //Click on 'EU GDPR' button
        pageObjects.HomePage.eu_GDPR.click();

        //Check the Page Title
        String EU_GDPR = driver.getTitle();
        System.out.println("EU_GDPR Title: "+EU_GDPR);
        assert EU_GDPR.contentEquals("GDPR Compliance – Data Protection Requirements | Omada");

        //Check displayed of the UE flag img
        Boolean flag = pageObjects.HomePage.ue_Flag_img.isDisplayed();
        System.out.println("The image with UE flag is displayed: "+flag);
        assert flag.equals(true);

        // Take screenshot and store as a file format
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {// now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("screenshot.png")); } catch (IOException e) {
            System.out.println(e.getMessage()); }

        //Scroll down to “8 steps to meeting the GDPR compliance requirements” and click on the “Download” button
        WebElement eight_steps = pageObjects.HomePage.eight_steps;
        new Actions(driver).moveToElement(eight_steps).perform();
        //Click download
        pageObjects.HomePage.cookies.click();
        pageObjects.HomePage.download.click();

        //Get the current window handle
        String windowHandle = driver.getWindowHandle();

        //Get the list of window handles
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        System.out.println("Dupa size: "+tabs);
        driver.switchTo().window((String) tabs.get(1));

        //Check the Page Title
        String EU = driver.getTitle();
        System.out.println("EU_GDPR Title: "+EU);
        assert EU.contentEquals("EU GDPR E-Book | Download Omada E-Book");

        //Check headerEU element
        wait.until(ExpectedConditions.elementToBeClickable(pageObjects.HomePage.headerEU));
        Boolean headerEU = pageObjects.HomePage.headerEU.isDisplayed();
        assert headerEU.equals(true);

        //Check CurrentUrl
        String url=driver.getCurrentUrl();
        System.out.println("CurrentUrl: "+url);
        assert url.equals("https://www.omada.net/en-us/more/resources/eu-gdpr-e-book");
    }


    @AfterTest
    public void teardown () {
        driver.quit();
    }


}