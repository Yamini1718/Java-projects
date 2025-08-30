package com.orangehrm.questions;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Q4 {
  @Test
  public void q4() throws Exception{
	  WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	  driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  WebElement dropdown=driver.findElement(By.name("my-select"));
	  Select select = new Select(dropdown);
      select.selectByVisibleText("Two");
      WebElement selectedOption = select.getFirstSelectedOption();
      System.out.println("Selected option: " + selectedOption.getText());
 driver.quit();
	  
  }
}
