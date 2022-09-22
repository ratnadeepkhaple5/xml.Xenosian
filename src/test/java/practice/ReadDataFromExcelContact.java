package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelContact {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sheet = wb.getSheet("Contact");
		
		Row row = sheet.getRow(1);
		
		Cell cell = row.getCell(2);
		
		String value = cell.getStringCellValue();
		
		System.out.println(value);
	}

}
