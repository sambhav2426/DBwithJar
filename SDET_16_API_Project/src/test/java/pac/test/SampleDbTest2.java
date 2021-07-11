package pac.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
//WAS to insert the value into database
public class SampleDbTest2 {

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
			String query="insert into students_info (regno, firstname, middlename, lastname) values('5', 'kiran','kumari', 'mourya')";
			
			//step 4: execute query
			 int res = stmt.executeUpdate(query);
			
			 //process and verify the result
			 if (res == 1) {
				 System.out.println("successfully students details created");
			}
			
		} catch (Exception e) {
			System.err.println("Students rows not created-----");
		}finally {
			//step 5: close the connection
			con.close();
			System.out.println("close connection");
		}

	}

}
