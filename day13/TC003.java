package day13;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php?");

       
        driver.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();

      
        List<WebElement> inputFields = driver.findElements(By.xpath("//input[@type='text']"));
        System.out.println("Total Count: " + inputFields.size());

       
    }
}
