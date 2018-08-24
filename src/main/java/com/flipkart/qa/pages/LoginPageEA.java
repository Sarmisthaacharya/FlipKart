package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.util.HighlightElement;

public class LoginPageEA extends TestBase{
	
	@FindBy(name="Username")
    WebElement Uname;
	
	@FindBy(name="Password")
    WebElement Pass;
	
	@FindBy(xpath="//button[@type='submit']")
    WebElement Submit;
	
	public LoginPageEA()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String un, String pass)
	{
		//HighlightElement.flash(username, driver);
		Uname.sendKeys(un);
		//HighlightElement.flash(password, driver);
		Pass.sendKeys(pass);
		HighlightElement.flash(Submit, driver);
	    Submit.click();  
	}

}
