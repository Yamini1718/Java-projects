package com.selinium;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Lab11_PageFactory {

	
   @FindBy(linkText = "Desktops")
	WebElement desktop;
	//By mac=By.linkText("Mac (1)");
	@FindBy(linkText = "Mac (1)")
	WebElement mac;
	//By sort=By.id("input-sort");
	@FindBy(id = "input-sort")
	WebElement sort;
	//By addtocart=By.xpath("//*[@id="content"]/div[2]/div/div/div[2]/div[2]/button[1]");
	@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")
	WebElement addtocart;
	//By search1=By.name("search");
	@FindBy(name = "search")
	WebElement search1;
	//By searchbutton1=By.xpath("//*[@id=\"search\"]/span/button");
	@FindBy(xpath = "//*[@id=\"search\"]/span/button")
	WebElement searchbutton1;
	//By searchcriteria=By.id("input-search");
	@FindBy(id = "input-search")
	WebElement searchcriteria;
	//By description=By.name("description");
	@FindBy(name = "description")
	WebElement description;
	//By searchbutton2=By.id("button-search");
	@FindBy(id = "button-search")
	WebElement searchbutton2;
	public void clickondesktop() {
		desktop.click();
	}
	public void clickonmac() {
		mac.click();
	}
	public void sort() {
		Select srt=new Select(sort);
		srt.selectByVisibleText("Name (A - Z)");
	}
	public void addtocart() {
		addtocart.click();
	}
	public void search1(String search) {
		search1.sendKeys(search);
	}
	public void searchbutton1() {
		searchbutton1.click();
	}
	public void searchcriteria() {
		searchcriteria.clear();
	}
	public void description() {
		description.click();
	}
	public void searchbutton2() {
		searchbutton2.click();
	}
}