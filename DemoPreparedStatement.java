package crud_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoPreparedStatement {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/crud_student";
		String userName = "postgres";
		String password = "root";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			
			String query = "insert into student values(?, ?, ?)";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 105);
			pstm.setString(2, "BCA");
			pstm.setInt(3, 26);
			int rowsAffected = pstm.executeUpdate();
			System.out.println(rowsAffected);
			con.close();
			System.out.println("Student is Added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
