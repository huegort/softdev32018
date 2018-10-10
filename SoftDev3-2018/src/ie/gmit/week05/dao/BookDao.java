package ie.gmit.week05.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

import ie.gmit.week05.model.Book;

public class BookDao {
	private static Object dumby = init();
	String url ="jdbc:mysql://localhost/its3";
	String user = "root";
	String password = "";
	private static Object init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException();
		}
		return null;
	}
	void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public Set<Book> getAll(){
		throw new UnsupportedOperationException();
	}
	public Book findById(String id) {
		throw new UnsupportedOperationException();
	}
	public void create(Book book) {
		String sql = "insert into book (isbn,datepublished,price) values (?,?,?);";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url,user, password);
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, book.getIsbn());
			ps.setObject(2, book.getDatePublished());
			ps.setInt(3, book.getPrice());
			ps.executeUpdate();
			
		}catch(SQLException sqle) {
			throw new RuntimeException();
		}finally{
			closeConnection(connection);
		}
		 
	}
	public void update(Book book) {
		
	}
	public void  delete(String id){
		
	}
	

}
