package day13;



import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC009 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://letcode.in/window");

        // Parent window handle
        String pwindow = driver.getWindowHandle();
        System.out.println("Parent window: " + pwindow);
        System.out.println("Parent URL: " + driver.getCurrentUrl());

        // Click 'home' - opens a new tab
        driver.findElement(By.id("home")).click();

        // Click 'multi' - opens multiple windows
        driver.findElement(By.id("multi")).click();

        // Get all window handles
        Set<String> mwindows = driver.getWindowHandles();
        System.out.println("All windows: " + mwindows);

        // Switch to each window and print URL
        for (String handle : mwindows) {
            driver.switchTo().window(handle);
            System.out.println("Window ID: " + handle + " | URL: " + driver.getCurrentUrl());
        }

        // Switch back to parent window
        driver.switchTo().window(pwindow);
        System.out.println("Back to Parent URL: " + driver.getCurrentUrl());

        driver.quit();
    }
}
