package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class JDBCExecuteQuery1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Driver driverref=new Driver();
		
		DriverManager.registerDriver(driverref);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "root");
		
		Statement state = conn.createStatement();
		
		ResultSet result = state.executeQuery("select * from emptable where name='Mohan';");
		
		while (result.next()) {
			
			System.out.println(result.getString(1)+"||"+result.getString(2)+"||"+result.getString(3));
		}
		
		conn.close();
	}

}
