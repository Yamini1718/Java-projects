package com.selinium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab8_JUnit {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @Test
    public void testFlow() throws Exception {
       
        driver.findElement(By.linkText("Desktops")).click();

        driver.findElement(By.linkText("Mac (1)")).click();

        WebElement macHeading = driver.findElement(By.xpath("//h2[text()='Mac']"));
        Assert.assertEquals("Mac", macHeading.getText());

        Select sort = new Select(driver.findElement(By.id("input-sort")));
        sort.selectByVisibleText("Name (A - Z)");

        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")).click();

        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys("Monitors");
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        driver.findElement(By.name("description")).click();
        driver.findElement(By.id("button-search")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}