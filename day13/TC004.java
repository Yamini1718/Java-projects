package day13;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
List<WebElement> alllinks=driver.findElements(By.tagName("a"));
System.out.println("Number of text input fields: " + alllinks.size());



for(WebElement link:alllinks) {
	System.out.println("the link is:"+link.getAttribute("href"));
	System.out.println("the link is:"+link.getText());
}
	}

}
