package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadTestCase {

	public static void main(String[] args) {

			//get path of excel file 
		File path=new File("C:\\Users\\KALPESH\\eclipse-workspace\\practice_automation\\ExcelFiles\\name.xlsx");
		
		//load excel file 
		try {
		FileInputStream load =new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(load);
		XSSFSheet sheet=workbook.getSheetAt(0);
		String read=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(read);
	}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		

}
}
