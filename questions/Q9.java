package com.orangehrm.questions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Q9 {
  @Test
  public void q9() throws IOException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    String projectPath = System.getProperty("user.dir"); 

    driver.get("https://www.wikipedia.org/");

    File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File dest = new File(projectPath + "\\Q9_Screenshot.png");

    FileUtils.copyFile(src, dest);

    driver.quit();
  }
}
