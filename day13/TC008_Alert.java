package day13;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC008_Alert {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://letcode.in/alert");

        driver.findElement(By.id("accept")).click();
        Alert salert = driver.switchTo().alert();

        System.out.println("The Message is: " + salert.getText());
        salert.accept();
        
        // Confirm Alert
        driver.findElement(By.id("confirm")).click();
        Alert calert = driver.switchTo().alert();
        System.out.println("Confirm Alert: " + calert.getText());
        calert.dismiss();

        // Prompt Alert
        driver.findElement(By.id("prompt")).click();
        Alert palert = driver.switchTo().alert();
        System.out.println("Prompt Alert: " + palert.getText());
        palert.sendKeys("Yamini");
        palert.accept();

        driver.quit();
    }
}
