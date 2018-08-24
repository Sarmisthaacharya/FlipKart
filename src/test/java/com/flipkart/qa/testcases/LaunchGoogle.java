package com.flipkart.qa.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchGoogle extends TestBase{
	
	
	LoginPage loginpage1;
	public static final Logger log= Logger.getLogger(LaunchGoogle.class.getName());
		
		public LaunchGoogle()
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
			
		loginpage1 = new LoginPage();
			
			
		}
		
		
		@Test
		public void loginfunctionality()
		{
			
			String title1 = loginpage1.validateTitle();
			System.out.println(title1);
		log.info("test");
		
			
		
		}
		
		
		
		@AfterMethod
		public void tearDown(ITestResult result) throws Exception 
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
