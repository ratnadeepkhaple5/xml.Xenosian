package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Exception {
		
		// st1: Load the file location into fileInputStream
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\commonData.properties");	
		
		//st2: create object of properties
		Properties pro=new Properties();
			
		//st3: Load the data into properties
		pro.load(fis);
		
		//st4:use the key and read the value
		String browser = pro.getProperty("browser");
		System.out.println(browser);
		
		String url = pro.getProperty("url");
		System.out.println(url);
	}

}
