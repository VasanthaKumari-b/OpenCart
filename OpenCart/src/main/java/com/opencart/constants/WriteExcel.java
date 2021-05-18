package com.opencart.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	/**
	 * Write the Exceldata 
	 * Create an object of File class to open xlsx file
	 * Create an object of FileInputStream class to read excel file 
	 * Find the file extension by splitting file name in substring and getting only extension name
	 * Check condition if the file is xlsx file If it is xlsx file then create object of XSSFWorkbook class Read excel sheet by sheet
	 * name Get the current count of rows in excel file Get the first row from
	 * the sheet Create a new row and append it at last of sheet Create a loop
	 * over the cell of newly created Row Fill data in row Close input stream
	 * Create an object of FileOutputStream class to create write data in excel
	 * file write data in the excel file close output stream
	 */
	public void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook Workbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			Workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			Workbook = new HSSFWorkbook(inputStream);
		}
		Sheet sheet = Workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row row = sheet.getRow(0);
		Row newRow = sheet.createRow(rowCount + 1);
		for (int j = 0; j < row.getLastCellNum(); j++) {
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToWrite[j]);
		}
		inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		Workbook.write(outputStream);
		outputStream.close();
	}
}
