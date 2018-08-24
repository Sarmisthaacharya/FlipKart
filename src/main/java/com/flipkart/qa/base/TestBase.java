package com.flipkart.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

import com.flipkart.qa.util.Screenshot;
import com.flipkart.qa.util.SendMail;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	
	static{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/reports/CustomReport" + formater.format(calendar.getTime()) + ".html", false);
		extent.addSystemInfo("Host Name", "Sarmistha")
		.addSystemInfo("Environment", "QA")
		.addSystemInfo("User Name", "Sarmistha Acharya");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	
	}
		
	public TestBase()
	{
		String log4jConPath="D:\\Data\\workspace\\Flipkart\\src\\main\\java\\com\\flipkart\\qa\\base\\log4j.properties";
		PropertyConfigurator.configure(log4jConPath);
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:\\Data\\workspace\\Flipkart\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
			
				prop.load(fis);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
			public static void initialization()
			{
				
				String browserName =  prop.getProperty("browser");
				if(browserName.equals("chrome"));
				{
					
					
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
					//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "/Drivers/IEDriverServer.exe");
					//driver = new InternetExplorerDriver();
				
				//driver = new FirefoxDriver();
				
				}
				/*else if(browserName.equals("IE"))
				{
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "/Drivers/IEDriverServer.exe");
					driver = new InternetExplorerDriver();	
				}*/
				/*else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "/Drivers/geckoedriver.exe");
					driver = new FirefoxDriver();	
				}*/
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		
			
			
			
			}
			
			
		public void getresult(ITestResult result) throws IOException, EmailException
		{
			if (result.getStatus() == ITestResult.SUCCESS)
{
test.log(LogStatus.PASS, result.getName() + "test is pass");
//SendMail.sendEMail();
}
			else if (result.getStatus() == ITestResult.SKIP)
			{
				test.log(LogStatus.SKIP, result.getName());
				test.log (LogStatus.SKIP, "test is skipped and skip reason is:" + result.getThrowable());
				
				}
			else if (result.getStatus() == ITestResult.FAILURE)
			{
				Screenshot.getScreenShot();
				test.log(LogStatus.ERROR, result.getName());
				test.log(LogStatus.ERROR,  "test is failed" + result.getThrowable());
				
				}
			
			else if (result.getStatus() == ITestResult.STARTED)
			{
				test.log(LogStatus.INFO, result.getName() + "test is started");
				}
		}
		

		
		@AfterClass(alwaysRun=true)
		public void endTest()
		{
			extent.endTest(test);
			extent.flush();
		}
		
	}


