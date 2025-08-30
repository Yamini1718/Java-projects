package com.orangehrm.questions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Q1 {
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void startReport() {
        ExtentSparkReporter reporter=new ExtentSparkReporter("ExtentReport.html");
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        test=extent.createTest("Google Title Test");
    }

    @Test
    public void q1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        
        test.log(Status.INFO,"Browser Launched");
        driver.get("https://www.google.com");
        
        test.log(Status.INFO,"Navigated to Google");
        String title=driver.getTitle();
        System.out.println("the title is "+title);
        if(title.contains("Google")){
            test.log(Status.PASS,"Title verified successfully: "+title);
        } else {
            test.log(Status.FAIL,"Title verification failed: "+title);
        }
        driver.quit();
        test.log(Status.INFO,"Browser Closed");
    }

    @AfterMethod
    public void endReport() {
        extent.flush();
    }
}
