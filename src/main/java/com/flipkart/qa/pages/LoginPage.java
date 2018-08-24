package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.util.HighlightElement;

public class LoginPage extends TestBase {
	
	Actions act = new Actions(driver);
	
	
	
	@FindBy(linkText ="Login & Signup")
	WebElement clickLogin;
	
	@FindBy(css="div[class*='_39M2dM'] > input")
	WebElement username;
	
	@FindBy(css="div[class*='Km0IJL col col-3-5'] > div > form > div:nth-child(2) > input")
	WebElement password;
    
	@FindBy(css="div._1avdGP > button > span")
	WebElement loginButton;
	
    @FindBy(xpath="//span[@class='_2cyQi_']") 
    WebElement loginHeader;
    
    @FindBy(xpath="//span[text()='My Account']")
    WebElement myAccountLink;
    
    @FindBy(xpath="//div[text()='My Profile']")
    WebElement myProfileLink;

public LoginPage()
{
	PageFactory.initElements(driver, this);
}


public String validateTitle()
{
	return driver.getTitle();
}

public void login(String un, String pass)
{
	//HighlightElement.flash(username, driver);
	username.sendKeys(un);
	//HighlightElement.flash(password, driver);
	password.sendKeys(pass);
	HighlightElement.flash(loginButton, driver);
    loginButton.click();  
}

public String validateLoginHeader()
{
	HighlightElement.flash(loginHeader, driver);
	return loginHeader.getText();
}

public void clickProfile()
{
	myAccountLink.click();
	myProfileLink.click();
}


}


