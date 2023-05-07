package vtiger.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class contains all the generic methods related to property files
 * 
 * @author Ratnadeep_Khaple
 *
 */
public class PropertyFileUtility {

	public String readDataFromFile(String key) throws IOException {
		
	//	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		FileInputStream fis=new FileInputStream(IConstantsUtility.PropertyFilePath);

		Properties pobj=new Properties();
		
		pobj.load(fis);
		
		String value=pobj.getProperty(key);
		
		return value;
	}
}
