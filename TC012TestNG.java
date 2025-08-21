package day26;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC012TestNG {
    WebDriver driver;
    String projectpath = System.getProperty("user.dir");

    ExtentReports extent;
    ExtentTest test;

    @BeforeClass
    public void setupReport() {
        String reportpath = projectpath + "\\Augreport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportpath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @AfterClass
    public void closeReport() {
        extent.flush();
    }

    @Test(dataProvider = "dp")
    public void f(String username, String password) throws InterruptedException {
        String title = driver.getTitle();
        System.out.println("The Title is:" + title);

        test = extent.createTest("Verify the title of the page");

        if (title.equalsIgnoreCase("OrangeHRM")) {
            test.pass("Title is matched");
        } else {
            test.fail("Title is not matched");
        }

        Thread.sleep(3000);

        login_pageobjects obj = new login_pageobjects(driver);
        obj.enterusername(username);
        obj.enterpassword(password);
        obj.clickonlogin();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
        driver.quit();
    }

    @DataProvider
    public Object[][] dp() throws IOException {
        File file1 = new File(projectpath + "\\data.xlsx");
        System.out.println("file path is:" + file1);
        FileInputStream fs = new FileInputStream(file1);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        int rowcount = worksheet.getPhysicalNumberOfRows();
        System.out.println("rows:" + rowcount);

        String[][] data = new String[rowcount][2];

        for (int i = 0; i < rowcount; i++) {
            data[i][0] = worksheet.getRow(i).getCell(0).getStringCellValue();
            data[i][1] = worksheet.getRow(i).getCell(1).getStringCellValue();
        }

        workbook.close();
        fs.close();

        return data;
    }
}
