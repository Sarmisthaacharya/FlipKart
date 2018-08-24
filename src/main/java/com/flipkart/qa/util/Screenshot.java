package com.flipkart.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.flipkart.qa.base.TestBase;

public class Screenshot extends TestBase {
	
	public static void getScreenShot() throws IOException
	{
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
		
		
		
		String reportDirectory = new File(System.getProperty("user.dir")) + "/Screenshots/";
		File destFile = new File((String) reportDirectory + driver.getTitle() +"_" + formater.format(calendar.getTime()) + ".png");
		
FileUtils.copyFile(scrFile, destFile);
		
	//	String filePath = destFile.toString();
	
	
	//Reporter.log("<br><img src='" + filePath + "' height='100' width='100'/></br>");
		//Reporter.log("<a href=/screenshots/" + filePath + "><img src=/screenshots/" + filePath + " style=width:100px;height:100px;/>" + filePath + "</a><br/>");
		
	}

}
