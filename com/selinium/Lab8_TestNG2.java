package com.selinium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.Reporter;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_TestNG2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
        Reporter.log("Opened TutorialsNinja demo site", true);
    }

    @Test
    public void testFlow() {
        Reporter.log("Clicking on Desktops tab", true);
        driver.findElement(By.linkText("Desktops")).click();

        Reporter.log("Clicking on Mac", true);
        driver.findElement(By.linkText("Mac (1)")).click();

        Reporter.log("Verifying Mac heading", true);
        WebElement macHeading = driver.findElement(By.xpath("//h2[text()='Mac']"));
        Assert.assertEquals(macHeading.getText(), "Mac", "Mac heading verification failed!");

        Reporter.log("Selecting Name (A - Z) from Sort By", true);
        Select sort = new Select(driver.findElement(By.id("input-sort")));
        sort.selectByVisibleText("Name (A - Z)");

        Reporter.log("Clicking Add to Cart", true);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();


        Reporter.log("Searching for Monitors", true);
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        Reporter.log("Clicking Search in product descriptions", true);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement descCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.name("description")));
        descCheckbox.click();

        driver.findElement(By.id("button-search")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        Reporter.log("Browser closed", true);
    }
}
