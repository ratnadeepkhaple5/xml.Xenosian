package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelOrg {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	//step1: Load the location of file by using File Input Stream
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
	//step2: create a workbook
		Workbook wb = WorkbookFactory.create(fis);
	//step3: get into sheet
		Sheet sheet = wb.getSheet("Organisation");
	//step4: get into the row
		Row row = sheet.getRow(1);
	//step5:get into the cell
		Cell cell = row.getCell(2);
	//step6: read the value present the cell
		
		String value = cell.getStringCellValue();
		System.out.println(value);
	}

}
