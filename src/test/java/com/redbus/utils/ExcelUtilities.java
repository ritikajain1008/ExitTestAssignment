package com.redbus.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtilities {
	
	public static Map<String,String> getExecutionMapData(String sheetname) throws Exception
	{
		Map <String,String> executiondata = new HashMap<String,String>();
		try
		{
			FileInputStream fileInputStream = new FileInputStream(".//ExcelSheets//testData1.xlsx");
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet1 = workbook.getSheet(sheetname);
			
			int lastrownum = sheet1.getLastRowNum();	
			
			for(int i=0;i<=lastrownum;i++)
			{
			    Row row = sheet1.getRow(i);
				Cell keycell = row.getCell(0);
				String key = keycell.getStringCellValue().trim();
				
				Cell valuecell = row.getCell(1);
				String value = valuecell.getStringCellValue().trim();
				executiondata.put(key, value);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return executiondata;
	}
	

	public static Map<String,String> getTestData(String sheetname) throws Exception
	{
		Map <String,String> testdata = new HashMap<String,String>();
		try
		{
			FileInputStream fileInputStream = new FileInputStream(".//ExcelSheets//testData2.xlsx");
			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet2 = workbook.getSheet(sheetname);
			
			int lastrownum = sheet2.getLastRowNum();		
			for(int i=0;i<=lastrownum;i++)
			{
			    Row row = sheet2.getRow(i);
				Cell keycell = row.getCell(0);
				String key = keycell.getStringCellValue().trim();
				
				Cell valuecell = row.getCell(1);
				String value = valuecell.getStringCellValue().trim();
				testdata.put(key, value);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return testdata;
	}

	
}
	

