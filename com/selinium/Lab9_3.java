package com.selinium;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Optional;

public class Lab9_3 {
    WebDriver driver;

    @Test
    public void testDesktopsMac() throws InterruptedException {
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();

        WebElement sort = driver.findElement(By.id("input-sort"));
        Thread.sleep(2000);
        Select sle = new Select(sort);
        sle.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();
    }

    @Parameters("browser")
    @BeforeMethod
    public void beforeMethod(@Optional("chrome") String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void afterMethod() {
        if(driver != null) driver.quit();
    }
    
    
    @DataProvider
    public Object[][] dp() {
      return new Object[][] {
        new Object[] { 1, "a" },
        new Object[] { 2, "b" },
      };
    }
    @BeforeClass
    public void beforeClass() {
  	  System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
  	  System.out.println("After class");
    }

    @BeforeTest
    public void beforeTest() {
  	  System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
  	  System.out.println("After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
  	  System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
  	  System.out.println("After Suite");
    }

  
}
