package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class login_pageobjects {
	WebDriver driver;
	public login_pageobjects(WebDriver driver2) {
		// TODO Auto-generated constructor stub
			this.driver=driver2;
	}
 
	By uname=By.name("username");
	By pword=By.name("password");
	By loginbutton=By.xpath("//button[@type='submit']");
	
 
	public void enterusername(String username)
	{
		driver.findElement(uname).sendKeys(username);
	}
	
	
	public void enterpassword(String password)
	{
		driver.findElement(pword).sendKeys(password);
	}
	
	
	public void clickonlogin()
	{
		driver.findElement(loginbutton).click();
	}}