package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * @author Ratnadeep_Khaple
 *
 *this class contains all the generic methods related to 'Java'
 */
public class JavaUtility {

	/**
	 * this will generate random integer number for every execution
	 * @return
	 */
	public int getRandomNumber() {
		Random random=new Random();
		int rNo=random.nextInt(1000);
		
		return rNo;
	}
	
	/**
	 * this method will return current system date 
	 * @return
	 */
	public String getSystemDate() {
		Date d=new Date();
		String date = d.toString();
		
		return date;
	}
//Fri Aug 26 16:34:24 IST 2022
//0    1  2     3	   4	5  <---indexing format for date array
	public String getsystemDateFormat() {
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		
		String date=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replace(":", "-");
		String currentDate=date+" " +month+" "+year+" "+time;
		
		return currentDate;
		
	}
}
