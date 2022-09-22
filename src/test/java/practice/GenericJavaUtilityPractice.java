package practice;

import java.io.IOException;

import vtiger.GenericUtility.ExcelFileUtility;
import vtiger.GenericUtility.JavaUtility;
import vtiger.GenericUtility.PropertyFileUtility;

public class GenericJavaUtilityPractice {

	public static void main(String[] args) throws IOException {
		
//1) javautility check-->
		
		JavaUtility jut=new JavaUtility();
		int ran=jut.getRandomNumber();
		System.out.println(ran);
		
		String date = jut.getSystemDate();
		System.out.println(date);//Fri Aug 26 16:34:24 IST 2022
		
		String d=jut.getsystemDateFormat();
		System.out.println(d);//26 Aug 2022 16-57-09
		
//2) PropertyFilesUtility check-->
		
		PropertyFileUtility pfu=new PropertyFileUtility();
		
		String browser = pfu.readDataFromFile("browser");
		System.out.println(browser);//Chrome

//3) ExcelFileUtility Check-->
		
		ExcelFileUtility efu=new ExcelFileUtility();
		String orgName = efu.readDataFromExcel("Organisation", 4, 2);
		System.out.println(orgName);
		
		efu.writeDataIntoExcel("Organisation", 4, 4,"sunny");
		System.out.println("data written..!");
		
		
		
	}

}
