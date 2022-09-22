package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains all generic methods regarding 'Excel' sheet
 * @author Ratnadeep_Khaple
 *
 */
public class ExcelFileUtility {

	/**
	 * this method will read the data from excel sheet & it required sheet name;
	 * row number,cell number to be entered
	 * @param sheet
	 * @param rownum
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet,int rownum,int cellNo) throws EncryptedDocumentException, IOException {
		
//	FileInputStream fis=new FileInputStream("\\src\\test\\resources\\TestData1.xlsx");
	//OR
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExelFilePath);//FileNotFoundException
		Workbook workbook = WorkbookFactory.create(fis);//EncryptedDocumentException,IOException
		Sheet sh=workbook.getSheet(sheet);
		Row row=sh.getRow(rownum);
		Cell cell = row.getCell(cellNo);
		String value = cell.getStringCellValue();
		
		workbook.close();

		return value;
	}
	public void writeDataIntoExcel(String sheet,int rownum,int cellNo,String setValue) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IConstantsUtility.ExelFilePath);
		Workbook wb = WorkbookFactory.create(fis);//EncryptedDocumentException,IOException
		Sheet sh = wb.getSheet(sheet);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellNo);
//Imp-->
	//	1)to set value in specific cell
		cell.setCellValue(setValue);
	//  2)"to set the path" to write data
		FileOutputStream fos=new FileOutputStream(IConstantsUtility.ExelFilePath);
	//  2)to 'Write' the data in that specific cell	
		wb.write(fos);
		
		wb.close();
	}
}
