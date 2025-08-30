package com.orangehrm.questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q3 {
  @Test
  public void q3() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in/");
	  Thread.sleep(3000);
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  List<WebElement> products = driver.findElements(By.cssSelector("h2.a-size-medium.a-spacing-none.a-color-base.a-text-normal span"));
	  System.out.println("five products");
	  for(int i=1;i<5&& i< products.size();i++) {
		  System.out.println(products.get(i).getText());
		  
	  }

	  driver.quit();
  }
}
