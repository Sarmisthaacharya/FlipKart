package com.flipkart.qa.util;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenerateExtentReport {
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	@BeforeTest
	public static void startReport()
	{
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/MyOwnReport.html", true);
		extent.addSystemInfo("HostName", "Sarmistha")
		.addSystemInfo("Environment", "QA")
		.addSystemInfo("User Name", "Sarmistha Acharya");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	}

	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}

@Test
public void passTest()
{
	logger = extent.startTest("Pass");
	Assert.assertTrue(true);
	logger.log(LogStatus.PASS, "Test Case Passed");
}

@AfterMethod
public void getResult(ITestResult result)
{
	if (result.getStatus() == ITestResult.FAILURE){
		logger.log(LogStatus.FAIL, "Test case fail" + result.getName());
	}
extent.endTest(logger);

}


}


