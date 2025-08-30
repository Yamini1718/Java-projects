package com.orangehrm.questions;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Q6 {
  @Test
  public void q6() {
	  WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://the-internet.herokuapp.com/checkboxes");
      List<WebElement> checkboxes = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));
      for (WebElement checkbox : checkboxes) {
          if (!checkbox.isSelected()) {
              checkbox.click();
          }
      }
      
      for (WebElement checkbox : checkboxes) {
          Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected!");
      }
      
      
      driver.quit();

  }
}
