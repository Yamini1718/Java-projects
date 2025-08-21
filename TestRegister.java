package day26;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class TestRegister {
    WebDriver driver;
    String projectpath = System.getProperty("user.dir");

    @Test(dataProvider = "dp")
    public void f(String firstname, String lastname, String email_id, String phnnumber,
                  String password, String confirmpassword) throws InterruptedException {
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println("Title:" + title);

        if (title.equals("Your Store")) {
            System.out.println("title is matched");
        } else {
            System.out.println("title is not matched");
        }

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Register")).click();

        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        if (text.getText().equals("Register Account")) {
            System.out.println("Text is matched");
        } else {
            System.out.println("text is mismatched");
        }

        // Enter all details from Excel
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(
                email_id.split("@")[0] + System.currentTimeMillis() + "@gmail.com"); // unique email
        driver.findElement(By.name("telephone")).sendKeys(phnnumber);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirm")).sendKeys(confirmpassword);

        // Newsletter checkbox
        WebElement newsletter = driver.findElement(By.name("newsletter"));
        if (!newsletter.isSelected()) {
            newsletter.click();
        }

        // Privacy policy
        driver.findElement(By.name("agree")).click();

        // Continue button
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit(); // ✅ close browser
        }
    }

    @DataProvider
    public Object[][] dp() throws IOException {
        String projectpath = System.getProperty("user.dir");
        File file = new File(projectpath + "\\UserDetails.xlsx");
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        int colcount = worksheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("rows:" + rowcount);

        // ✅ dynamically handle rows/cols (ignore header row)
        String[][] data = new String[rowcount - 1][colcount];
        for (int i = 1; i < rowcount; i++) {
            for (int j = 0; j < colcount; j++) {
                data[i - 1][j] = worksheet.getRow(i).getCell(j).toString();
            }
        }

        workbook.close();
        fs.close();
        return data;
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
