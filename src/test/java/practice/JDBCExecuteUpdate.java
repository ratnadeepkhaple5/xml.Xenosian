package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Driver driverref=new Driver();
		Connection conn=null;
	//	try {

			//step 1:register the driver
			DriverManager.registerDriver(driverref);

			//step 2:get the connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb", "root", "root");

			//step 3:issue create statement
			Statement state = conn.createStatement();

			//step 4: execute a query
			String quary = "insert into clientinfo values('sunny',555,'Tuljapur');";
			int result = state.executeUpdate(quary);

			System.out.println(result);

//			if (result==1) {
				System.out.println("data inserted");
//			}	
//		} catch (Exception e) {
//			e.getStackTrace();	
//		}
//		finally {
			//step 5: close database
			conn.close();
//		}

	}


}
