package pac.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
//WAS to get the value from database
public class SampleDbTest {
	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		
		try {
			//step 1: load/register mysql jdbc driver
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			//step 2: connect to database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			
			//step 3: issue on database query
			Statement stmt = con.createStatement();
			String query = "select * from students_info";
			
			//step 4: execute query
			ResultSet res = stmt.executeQuery(query);
			//process and verify the result
			while (res.next()) {
				System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t"+ res.getString(3));	
			}
			
		} catch (Exception e) {
			System.out.println("handle problem");
		}finally {
			//step 5: close the connection
			con.close();
			System.out.println("close connection");
		}
		
	
		
	}



}
