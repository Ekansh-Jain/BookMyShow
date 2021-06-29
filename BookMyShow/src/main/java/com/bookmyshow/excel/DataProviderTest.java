package com.bookmyshow.excel;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
	static String path=System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx";
	static ExcelImport ex=new ExcelImport(path);
	
	@DataProvider(name = "InvalidUser")
	public static String[][] getData() throws IOException {
		
		int c=ex.getCellCount("Sheet1", 1);
		
		String[][] signInData=new String[1][c-1];
		for(int j=0;j<(c-1);j++)
			signInData[0][j]=ex.getCellData("Sheet1", 1, j+1);
	
		return signInData;
	}
	
	@DataProvider(name = "InvalidPassword")
	public static String[][] getData1() throws IOException {
		
		int c=ex.getCellCount("Sheet1", 1);
		
		String[][] signInData=new String[1][c-1];
		for(int j=0;j<(c-1);j++)
			signInData[0][j]=ex.getCellData("Sheet1", 2, j+1);
	
		return signInData;
	}
	
	@DataProvider(name = "BlankUserName")
	public static String[][] getData2() throws IOException {
		
		int c=ex.getCellCount("Sheet1", 1);
		
		String[][] signInData=new String[1][c-1];
		for(int j=0;j<(c-1);j++)
			signInData[0][j]=ex.getCellData("Sheet1", 3, j+1);
	
		return signInData;
	}
	
	@DataProvider(name = "BlankPassword")
	public static String[][] getData3() throws IOException {
		
		int c=ex.getCellCount("Sheet1", 1);
		
		String[][] signInData=new String[1][c-1];
		for(int j=0;j<(c-1);j++)
			signInData[0][j]=ex.getCellData("Sheet1", 4, j+1);
	
		return signInData;
	}
	
	@DataProvider(name = "CorretCredentials")
	public static String[][] getData4() throws IOException {
		
		int c=ex.getCellCount("Sheet1", 1);
		
		String[][] signInData=new String[1][c-1];
		for(int j=0;j<(c-1);j++)
			signInData[0][j]=ex.getCellData("Sheet1", 5, j+1);
	
		return signInData;
	}

}
