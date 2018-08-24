package com.flipkart.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.LoginPageEA;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTestEA extends TestBase {
	
	
	
	LoginPageEA loginpage1;
	public static final Logger log= Logger.getLogger(LoginTestEA.class.getName());
		
		public LoginTestEA()
		{
			super();
		}

		
		@BeforeMethod
		public void setUp(Method result)
		{
			initialization();
			test = extent.startTest(result.getName());
			test.log(LogStatus.INFO, result.getName() + " test Started" );
			
		log.info("URL opened");
			
			loginpage1 = new LoginPageEA();
			
			
		}
		
		
		@Test
		public void loginfunctionality()
		{
			
		
		log.info("test");
			
		
		}
		
		
		
		@AfterMethod
		public void tearDown(ITestResult result) throws EmailException
			{
			
			/*if(result.getStatus() == ITestResult.FAILURE)
			{
				ExtentTest.log(LogStatus.FAIL, result.getThrowable());
			}*/
			
			try {
				getresult(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.quit();
			
		}
	}
 

