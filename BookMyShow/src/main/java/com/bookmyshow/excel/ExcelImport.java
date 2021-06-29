package com.bookmyshow.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelImport {
	public FileInputStream fileInput;
	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;
	
	public ExcelImport(String path){
		this.path=path;
	}
	
	public int getRowCount(String SheetName) throws IOException {
		fileInput= new FileInputStream(path);
		wb=new XSSFWorkbook(fileInput);
		sheet=wb.getSheet(SheetName);
		int rowCount=sheet.getLastRowNum();
		wb.close();
		fileInput.close();
		return rowCount;
	}
	
	public int getCellCount(String SheetName,int rowNum) throws IOException {
		fileInput= new FileInputStream(path);
		wb=new XSSFWorkbook(fileInput);
		sheet=wb.getSheet(SheetName);
		row=sheet.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fileInput.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName,int rowNum,int colNum) throws IOException {
		fileInput= new FileInputStream(path);
		wb=new XSSFWorkbook(fileInput);
		sheet=wb.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		DataFormatter format=new DataFormatter();
		String data;
		try {
			data=format.formatCellValue(cell);
		}catch(Exception e) {
			data="";
		}
		wb.close();
		fileInput.close();
		return data;
	}	
	
}
