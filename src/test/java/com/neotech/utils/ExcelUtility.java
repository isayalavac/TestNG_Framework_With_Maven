package com.neotech.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static Workbook book;
	static Sheet sheet;
	
	public static void openExcel(String filePath) {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			book = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void loadSheet(String sheetName) {
		 sheet = book.getSheet(sheetName);
	}
	public static int rowCount() {
	   return sheet.getPhysicalNumberOfRows();
	}

	public static int colCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}
	
	public static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}
	
	// return a 2D-Object Array
	public static Object [][] excelIntoArray(String filePath, String sheetName){
		
		openExcel(filePath);
		loadSheet(sheetName);
		
		int rows = rowCount();
		int cols = colCount(0);
		
		// I used row-1 to skip the header
		Object [][] data = new Object[rows-1][cols];
		
		// iterating rows
		//Started from 1 to skip the header
		for(int  row = 1; row<rows; row++) 
		{
			
			//iterating columns
			for(int col = 0; col<cols; col++)
			{
				// read from excel into 2d-Object Array
				data[row-1][col] = cellData(row, col);
			}
			
		}
		// return the object that has been filled
		return data;
	}
	
}
