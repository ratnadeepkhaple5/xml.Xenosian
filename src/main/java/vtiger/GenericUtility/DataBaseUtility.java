package vtiger.GenericUtility;
/**
 * this class contains all the generic methods related to 'database'
 * @author Ratnadeep_Khaple
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Driver driverRef;
	Connection con=null;
	
	/**
	 * This method will establish the connection with database
	 * @throws SQLException
	 */
	public void connectDB() throws SQLException {
		
		driverRef=new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		DriverManager.getConnection(IConstantsUtility.DBUrl, IConstantsUtility.DBusername, IConstantsUtility.DBpassword);
		
	}
	/**
	 * this method will close the database connection
	 * @throws SQLException
	 */
	public void close() throws SQLException {
	
		con.close();
	}
	/**
	 * this method will execute the query and verified the data from database
	 * and return the data if expData and actData are same or matching
	 * else it will return the empty string
	 * 
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryVerifyDataAndReturn(String query,int columnIndex,String expData) throws SQLException {
		//execute query		
	
		boolean flag=false;
//		Statement state = con.createStatement();
//		ResultSet result = state.executeQuery(query);
		//OR
		ResultSet result = con.createStatement().executeQuery(query);
		
		while (result.next()) {	
			
			String actData=result.getString(columnIndex);
			
	    // Verifying the expData and actData from Database		
			
			if (actData.equals(expData)) {
				flag=true;
				break;
			}
		}
		//return if exp data and act data is matching
		if (flag) {
			System.out.println("Data verified..!");
			return expData;
		}
		else {
			System.out.println("Data Not Verified..!");
			return " ";
		}
	}
	
}
