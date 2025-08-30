package com.orangehrm.questions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Q2 {
  @Test
  public void q2() {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	 
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/login");
	  driver.findElement(By.name("username")).sendKeys("tomsmith");
	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
	  driver.findElement(By.className("radius")).click();
	  String message=driver.findElement(By.id("flash")).getText();
	  System.out.println(message);
	  driver.quit();
  }
}
