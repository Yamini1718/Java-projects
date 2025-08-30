package com.orangehrm.questions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Q5 {
  @Test
  public void q5() throws Exception{
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.manage().window().maximize();
      driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
      driver.switchTo().alert().accept();
      Thread.sleep(3000);
      String result = driver.findElement(By.id("result")).getText();
      Assert.assertEquals(result, "You successfully clicked an alert", "Alert result message mismatch!");
Thread.sleep(3000);
      driver.quit();

	  
  }
}
