package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDatabase {
	
	public static void main(String args[])
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql?useSSL=false", "root", "093410");
			// MySQL�� ���� �õ�
			
			String query = "SELECT HOST FROM USER";
				
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			System.out.println("<���̺� ��� ���>");
			
			while(rs.next()) {
				System.out.println(rs.getString(1));  // ������ ���� �� ����� ���
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}