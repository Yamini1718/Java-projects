package com.selinium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12 {
    WebDriver driver;
    Properties prop;

    @BeforeClass
    public void setUp() throws IOException {
        // Load config file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("configuration/config.properties");
        prop.load(fis);

        // Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open URL
        driver.get(prop.getProperty("url"));
    }

    @Test(priority = 1)
    public void verifyMacPage() {
        // Click Desktops
        driver.findElement(By.linkText(prop.getProperty("desktop_tab"))).click();

        // Click Mac (1)
        driver.findElement(By.linkText(prop.getProperty("mac_link"))).click();

        // Verify Mac page heading
        String heading = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(heading, prop.getProperty("mac_heading"), "Mac Page Heading mismatch!");
    }

    @Test(priority = 2)
    public void verifySearchFunctionality() {
        // Enter text in search box
        driver.findElement(By.xpath(prop.getProperty("search_box"))).sendKeys("Mac");

        // Click search button
        driver.findElement(By.xpath(prop.getProperty("search_button"))).click();

        // Verify search criteria text
        String criteria = driver.findElement(By.name(prop.getProperty("search_criteria"))).getAttribute("value");
        Assert.assertEquals(criteria, "Mac", "Search criteria mismatch!");

        // Check 'Search in product descriptions'
        WebElement desc = driver.findElement(By.name(prop.getProperty("description_checkbox")));
        if (!desc.isSelected()) {
            desc.click();
        }

        // Click final search button
        driver.findElement(By.id(prop.getProperty("final_search_button"))).click();

        // Verify results contain "Mac"
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Search"), "Search results page not displayed!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @BeforeClass
    public void beforeClass() { System.out.println("Before Class"); }
    @AfterClass
    public void afterClass() { System.out.println("After Class"); }
    @BeforeTest
    public void beforeTest() { System.out.println("Before Test"); }
    @AfterTest
    public void afterTest() { System.out.println("After Test"); }
    @BeforeSuite
    public void beforeSuite() { System.out.println("Before Suite"); }
    @AfterSuite
    public void afterSuite() { System.out.println("After Suite"); }
}
