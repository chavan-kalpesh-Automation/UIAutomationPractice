package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteTestCase {

	public static void main(String[] args) {

		// get path of excel file
		File path = new File("C:\\Users\\KALPESH\\eclipse-workspace\\practice_automation\\ExcelFiles\\name.xlsx");

		// load excel file
		try {
			FileInputStream load = new FileInputStream(path);
			//access workbook
			XSSFWorkbook workbook =new XSSFWorkbook(load);
			XSSFSheet sheet =workbook.getSheetAt(0);
			
			//perform output action on output stream 
			FileOutputStream write =new FileOutputStream(path);
			sheet.createRow(0).createCell(1).setCellValue("chavan");
			workbook.write(write);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
