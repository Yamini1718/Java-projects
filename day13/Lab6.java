package day13;






import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6
{
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/index.php?");
		System.out.println("Title :" + driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a ")).click();
		 driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys("aditya234@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Aditya@123");		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
			Thread.sleep(3000);
		
       
		driver.findElement(By.linkText("Components")).click();
		driver.findElement(By.linkText("Monitors (2)")).click();
		WebElement sort = driver.findElement(By.id("input-limit"));
		
		Select sel = new Select(sort);
		sel.selectByIndex(1);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/ul[2]/li[2]/a")).click();
		System.out.println("The Related products are available");

		
		
		//System.out.println("The message : " + ((WebElement) driver).getText());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();
		System.out.println("'Success: You have added Apple Cinema 30\" to your wish list!'");
		driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("Mobile");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.id("description")).click();
		driver.findElement(By.id("button-search")).click();
		driver.findElement(By.linkText("HTC Touch HD")).click();
		driver.findElement(By.id("input-quantity")).clear();
		driver.findElement(By.id("input-quantity")).sendKeys("3");
		driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
		System.out.println("'Success: You have added HTC Touch HD to your  shopping cart!'");
		Thread.sleep(3000);
		driver.findElement(By.id("cart-total")).click();
		driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")).click();
		System.out.println("'Products markd with *** are not available in the desired quantity or not in stock!'");
		driver.findElement(By.linkText("Checkout")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Verify 'Account Logout' heading in process");
		driver.findElement(By.linkText("Continue")).click();

		
	}
	
}