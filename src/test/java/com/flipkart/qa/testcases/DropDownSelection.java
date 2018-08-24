package com.flipkart.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownSelection {
	
	WebDriver driver;
	
	@Test
	public void dropDown(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("https://www.facebook.com");
    
    WebElement ele = driver.findElement(By.id("month"));
    Select sel = new Select(ele);
    
    List<WebElement> li = sel.getOptions();
    for(WebElement list: li)
    {
    	System.out.println(list.getText());
    }
    
    
}

}
