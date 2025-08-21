package day26;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC012_TestNG {
    WebDriver driver;

    @Test(dataProvider = "dp")
    @DataProvider
    public Object[][] dp() throws IOException {
    String[][] data=new String[3][2];
  	  
  	  String projectpath=System.getProperty("user.dir")  ;
  	  File file1=new File(projectpath+"\\data.xlsx");
  	  FileInputStream fs=new FileInputStream(file1);
  	  XSSFWorkbook workbook=new XSSFWorkbook(fs);
  	  XSSFSheet worksheet=workbook.getSheetAt(0);
  	  int rowcount=worksheet.getPhysicalNumberOfRows();
  	  System.out.println("rows:"+rowcount);
  	  
  	  for(int i=0;i<=rowcount;i++)
  	  {
  		  data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
  	
  		  data[i][1]=worksheet.getRow(i).getCell(1).getStringCellValue();
  	  }
  	  
  	  return data;
  	  
      
      }
   
    public void f(String username, String password) throws InterruptedException {
        String title = driver.getTitle();
        System.out.println("The Title is:" + title);
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
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
    public Object[][] dp() {
        return new Object[][] {
            new Object[] { "Admin", "admin123" },
            new Object[] { "pooja", "admin123" }
        };
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
