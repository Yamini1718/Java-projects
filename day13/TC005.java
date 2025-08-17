package day13;



	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class TC005{
	    public static void main(String[] args) {
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("http://www.automationpractice.pl/index.php");

	        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

	        if (driver.findElement(By.id("email_create")).isDisplayed()) {
	            System.out.println("email create is displayed");
	            driver.findElement(By.id("email_create")).clear();
	            driver.findElement(By.id("email_create")).sendKeys("assfsdf@gmail.com");
	            driver.findElement(By.id("email_create")).sendKeys(Keys.TAB);
	            driver.findElement(By.id("email_create")).sendKeys(Keys.ENTER);
	        } else {
	            System.out.println("email create is not displayed");
	        }

	        driver.quit();
	    }
	}
