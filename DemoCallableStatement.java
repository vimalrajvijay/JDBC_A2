package callable_statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoCallableStatement {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/crud_student";
		String userName = "postgres";
		String password = "root";
		
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			
			String query = "call abc(?, ?, ?)";
			CallableStatement cs = con.prepareCall(query);
			cs.setInt(1, 104);
			cs.setString(2, "PQR");
			cs.setInt(3, 25);
			
			cs.execute();
			System.out.println("Inserted");
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
