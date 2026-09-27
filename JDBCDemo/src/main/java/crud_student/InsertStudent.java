package crud_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudent {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/crud_student";
		String userName = "postgres";
		String password = "root";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			Statement stm = con.createStatement();
			String query = "insert into student values(103,'MNO',25)";
			stm.execute(query);
			con.close();
			System.out.println("Student is Added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
