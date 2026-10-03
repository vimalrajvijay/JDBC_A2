package prepared_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClosingTheConnectionUsingFinally {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/crud_student";
		String userName = "postges";
		String password = "root";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, password);
			String query = "select * from student where id = ? and name = ?";
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, 102);
			pstm.setString(2, "XYZ");
			pstm.execute();
			ResultSet rs = pstm.getResultSet();
			rs.next();
			System.out.println("Id   : "+rs.getInt(1));
			System.out.println("Name : "+rs.getString(2));
			System.out.println("Age  : "+rs.getInt(3));
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
