package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Driver driverref=new Driver();
	
	//step 1: Register the databases/driver
		DriverManager.registerDriver(driverref);
		
	//step 2:Get the connection with database - provide database name as clientdb
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root", "root");

	//step 3:issue create statement
	Statement state = conn.createStatement();
	
	//step 4:execute a quary - provide table name
	ResultSet result = state.executeQuery("select * from clientinfo;");
	
	while (result.next()) {
		
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	}
	//step 5: close the database
	conn.close();
	}

}
