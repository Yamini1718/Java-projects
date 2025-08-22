package  com.selinium;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lab14 {
    WebDriver driver;

    @Test(dataProvider = "dp")
    public void registerUser(String firstname, String lastname, String email_id, String phnnumber, String password, String confirmpassword) throws InterruptedException {
        Thread.sleep(2000);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        if(title.equals("Your Store")) {
            System.out.println("Title is matched");
        } else {
            System.out.println("Title is NOT matched");
        }

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.linkText("Register")).click();

        WebElement text = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        if(text.getText().equals("Register Account")) {
            System.out.println("Text is matched");
        } else {
            System.out.println("Text is mismatched");
        }

        // Fill registration form
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(email_id);
        driver.findElement(By.name("telephone")).sendKeys(phnnumber);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirm")).sendKeys(confirmpassword);

        // Click newsletter checkbox (optional)
        driver.findElement(By.name("newsletter")).click();

        // Agree to privacy policy
        driver.findElement(By.name("agree")).click();

        // Click continue
        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");
    }

    @AfterMethod
    public void afterMethod() {
        if(driver != null) driver.quit();
    }

    @DataProvider
    public Object[][] dp() throws IOException {
        File file = new File("C:\\Users\\yamin\\eclipse-workspace\\August2nd\\UserDetails.xlsx");
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowcount = sheet.getPhysicalNumberOfRows();
        int colcount = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[rowcount][colcount];

        for(int i = 0; i < rowcount; i++) {
            for(int j = 0; j < colcount; j++) {
                if(sheet.getRow(i).getCell(j).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC) {
                    data[i][j] = String.valueOf((long)sheet.getRow(i).getCell(j).getNumericCellValue());
                } else {
                    data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
        }

        workbook.close();
        fs.close();
        return data;
    }

    @BeforeClass
    public void beforeClass() { System.out.println("Before Class"); }
    @AfterClass
    public void afterClass() { System.out.println("After Class"); }
    @BeforeTest
    public void beforeTest() { System.out.println("Before Test"); }
    @AfterTest
    public void afterTest() { System.out.println("After Test"); }
    @BeforeSuite
    public void beforeSuite() { System.out.println("Before Suite"); }
    @AfterSuite
    public void afterSuite() { System.out.println("After Suite"); }
}
