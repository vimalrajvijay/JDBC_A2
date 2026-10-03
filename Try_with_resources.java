package prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Try_with_resources {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/crud_student";
		String userName = "postgres";
		String password = "root";
		try(Connection con = DriverManager.getConnection(url, userName, password);) {
			Statement stm = con.createStatement();
			String query = "update student set age = 22 where id = 101";
			stm.execute(query);
			con.close();
			System.out.println("Student is Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
