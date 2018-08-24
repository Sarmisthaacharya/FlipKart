package com.flipkart.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static void main(String[] args) throws Exception
	{
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	
	
	String path ="D:\\Data\\workspace\\Flipkart\\src\\main\\java\\com\\flipkart\\qa\\testdata\\TestData.xlsx";
	
	
		
		
			fis = new FileInputStream(path);
			 wb = new XSSFWorkbook(fis);
			 sheet1 = wb.getSheetAt(0);
			
	int rowCount = sheet1.getLastRowNum();
	System.out.println(rowCount);
	
	XSSFRow row = sheet1.getRow(0);
	
	int countCell = row.getLastCellNum();
	System.out.println(countCell);
	
	for(int i=1; i<rowCount; i++)
	{
		for(int j =0; j<countCell; j++)
		{
			System.out.print(sheet1.getRow(i).getCell(j).getStringCellValue() + " ");
		}
		
		System.out.println();
	}
		
		
	System.out.println(sheet1.getRow(0).getCell(0).getStringCellValue());
		
	}
	}
	

