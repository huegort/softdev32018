package ie.gmit.week05.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testQuery {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost/its3";
		String user = "root";
		String password = "";
		Connection connection = null; 
		try {		
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "select * from book;";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("isbn"));
			}
		}finally {
			connection.close();
		}
			

	}

}
