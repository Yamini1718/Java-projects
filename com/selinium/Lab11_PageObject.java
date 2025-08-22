package com.selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Lab11_PageObject {
WebDriver driver;

public Lab11_PageObject(WebDriver driver) {
	
	this.driver = driver;
}
By desktop=By.linkText("Desktops");
By mac=By.linkText("Mac (1)");
By sort=By.id("input-sort");

By addtocart=By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]");
By search1=By.name("search");
By searchbutton1=By.xpath("//*[@id=\"search\"]/span/button");
By searchcriteria=By.id("input-search");
By description=By.name("description");
By searchbutton2=By.id("button-search");
public void clickondesktop() {
	driver.findElement(desktop).click();
}
public void clickonmac() {
	driver.findElement(mac).click();
}
public void sort() {
	Select srt=new Select(driver.findElement(sort));
	srt.selectByVisibleText("Name (A - Z)");
}
public void addtocart() {
	driver.findElement(addtocart).click();
}
public void search1(String search) {
	driver.findElement(search1).sendKeys(search);
}
public void searchbutton1() {
	driver.findElement(searchbutton1).click();;
}
public void searchcriteria() {
	driver.findElement(searchcriteria).clear();
}
public void description() {
	driver.findElement(description).click();
}
public void searchbutton2() {
	driver.findElement(searchbutton2).click();
}
}