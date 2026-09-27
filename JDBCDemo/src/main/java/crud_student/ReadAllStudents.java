package crud_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadAllStudents {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/crud_student";
		String userName = "postgres";
		String password = "root";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement stm = con.createStatement();
			String query = "select * from student where id = 102";
			stm.execute(query);
			
			ResultSet rs = stm.getResultSet();
			while(rs.next()) {
				System.out.println("ID   : "+rs.getInt(1));
				System.out.println("Name : "+rs.getString(2));
				System.out.println("Age  : "+rs.getInt(3));
				System.out.println("---------------");
			}
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
