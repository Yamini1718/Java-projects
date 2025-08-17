package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_Selinum_Dropdown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php?");
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Mac (1)")).click();
        WebElement sort = driver.findElement(By.id("input-sort"));
        Select sle = new Select(sort);
        List<WebElement> elecount=sle.getOptions();
        for(int i=0;i<elecount.size();i++) {
        	System.out.println("the values:"+elecount.get(i).getText());
    }
}


}
