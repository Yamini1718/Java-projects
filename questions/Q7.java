package com.orangehrm.questions;

import org.testng.annotations.Test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
import org.openqa.selenium.WebElement;



public class Q7 {
  @Test
  public void q7() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://the-internet.herokuapp.com/tables");

   
      List<WebElement> names = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr/td[2]"));
      System.out.println("All Names from Table 1:");
      for (WebElement name : names) {
          System.out.println(name.getText());
      }

      String emailXpath = "//table[@id='table1']//tbody//tr[td[2]='Jason']/td[3]";
      WebElement emailElement = driver.findElement(By.xpath(emailXpath));
      System.out.println("\nEmail of Jason: " + emailElement.getText());
      driver.quit();
  }
  }

