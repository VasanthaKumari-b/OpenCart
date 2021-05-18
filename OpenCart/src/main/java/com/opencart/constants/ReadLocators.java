package com.opencart.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReadLocators {
	public static Workbook book;
	public static Sheet sh;
	public static Cell cell;

	/**
	 * Set the Excelfile path
	 */
	public static void setExcelFile(String sheetname) throws IOException {
		String filePath = System.getProperty("user.dir");
		String fileName = "OpenCart.xlsx";
		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		sh = book.getSheet(sheetname);
	}

	/**
	 * Get the cell value from rowNumber and cell Number 
	 * return the cell value as string
	 */
	public static String getCellData(int rowNumber, int cellNumber) {
		cell = sh.getRow(rowNumber).getCell(cellNumber);
		return cell.getStringCellValue();
	}

	/**
	 * Get the row count in excelsheet
	 */
	public static int getRowCountInSheet() {
		int rowcount = sh.getLastRowNum() - sh.getFirstRowNum();
		return rowcount;
	}

	/**
	 * Get the cellValue
	 */
	public static String getcellvalue(String rowval) {
		int row = getRowCountInSheet();
		for (int i = 0; i <= row; i++) {

			Cell key = sh.getRow(i).getCell(0);

			String key1 = key.toString();
			if (key1.equalsIgnoreCase(rowval) == true) {
				cell = sh.getRow(i).getCell(1);
			}
		}

		return cell.getStringCellValue();

	}

}