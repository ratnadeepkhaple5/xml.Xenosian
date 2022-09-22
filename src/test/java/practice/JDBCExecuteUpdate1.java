package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCExecuteUpdate1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

	Driver driverref=new Driver();
	
	DriverManager.registerDriver(driverref);
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
	
	Statement state = conn.createStatement();
	
	String update = "insert into emptable values(5,'sunny',94226552);";
	
	int result = state.executeUpdate(update);
	
	//System.out.println(result);

	if (result==1) {
		
		System.out.println("data inserted..!");
	}
	conn.close();
	
	}
}


