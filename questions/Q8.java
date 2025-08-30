package com.orangehrm.questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import java.util.*;
import org.openqa.selenium.By;

public class Q8 {
  @Test
  public void q8() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/windows");
	  String parent = driver.getWindowHandle();
	  WebElement clickBtn = driver.findElement(By.linkText("Click Here"));
	  clickBtn.click();
	  Set<String> windows = driver.getWindowHandles();
	  for(String win : windows ) {
		  if(!win.equals(parent)) {
		  driver.switchTo().window(win);
			  System.out.println(driver.getTitle());
			  driver.close();
		  }
	  }
			  driver.switchTo().window(parent);
			  System.out.println(driver.getTitle());
			  driver.quit();
		  }
  }
