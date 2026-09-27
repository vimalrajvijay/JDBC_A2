package crud_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStudentTable {
	
	public static void main(String[] args) {
		
		try {
			//step 1 : Load the Driver
			Class.forName("org.postgresql.Driver");
			//step 2 : Create the Connection
			String url = "jdbc:postgresql://localhost:5432/crud_student";
			String userName = "postgres";
			String password = "root";
			Connection con = DriverManager.getConnection(url, userName, password);
			// step 3 : Create the Statement
			Statement stm = con.createStatement();
			// step 4 : Execute the sql query
			String query = "create table student (id int primary key, name varchar(20), age int)";
			stm.execute(query);
			//step 5 : Close the Connection
			con.close();
			
			System.out.println("Table is Created");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
