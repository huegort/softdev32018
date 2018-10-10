package ie.gmit.week05.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class TestJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost/its3";
		String user = "root";
		String password = "";
		Connection connection = null; 
		try {		
			connection = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into book (isbn,datepublished,price) values (?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, "123XV");
			ps.setObject(2, LocalDate.now());
			ps.setInt(3, 299);
			
			ps.executeUpdate();
		}finally {
			if (connection != null) connection.close();
		}
		
		//Connection connection 
		System.out.println("so far so good");
		

	}

}
