package com.flipkart.qa.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighlightElement {
	
	public static void flash(WebElement element, WebDriver driver)
	{
		String bgColor = element.getCssValue("backgroundColor");
		
		for(int i=0; i<10; i++)
		{
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgColor, element, driver);
		}
		
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try{
			Thread.sleep(20);
		}
		catch(InterruptedException e)
		{
			
		}
	}

}
