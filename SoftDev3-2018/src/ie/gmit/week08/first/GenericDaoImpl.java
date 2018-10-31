package ie.gmit.week08.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import ie.gmit.week05.model.Book;

public abstract class  GenericDaoImpl<T> implements GenericDao<T>{
	private static Object dumby = init();
	String url ="jdbc:mysql://localhost/its3";
	String user = "root";
	String password = "";
	private final Class<T> type;
	
	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	abstract T marshalEntity(ResultSet rs) throws SQLException;
	abstract void populatePsId(PreparedStatement ps, T entity) throws SQLException;
	abstract void populatePs(PreparedStatement ps, T entity) throws SQLException ;
	abstract String getSetId() ;
	abstract String getSets() ;

	
	private static Object init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("whoops");
			e.printStackTrace();
		}
		return null;
	}
	String getTableName() {
		System.out.println(type.getSimpleName());
		return type.getSimpleName();
	};

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user, password);

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
	public Set<T> getAll() {
		Connection conn = null;
		Set<T> returnSet = null;
		try {
			conn= getConnection();
			String sql = "select * from "+getTableName()+";";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			returnSet = new HashSet<T>();
			while (rs.next()) {
				T entity = marshalEntity(rs);
				returnSet.add(entity);
			}
			
		}catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally {
			closeConnection(conn);
		}
		return returnSet;
	}
	public void update(T entity) {
		Connection conn = null;
		try {
			 conn = getConnection();
			 // update book set c1 = ? .... where cid = ?
			 StringBuilder sb = new StringBuilder();
			 sb.append("update ");
			 sb.append(getTableName());
			 sb.append(" set ");
			 sb.append(getSets());
			 sb.append(" where ");
			 sb.append(getSetId());
			 sb.append(";");
			 
			 String sql = sb.toString();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 populatePs(ps, entity);
			 populatePsId(ps,entity);
			 
			 ps.executeUpdate();
			 
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			this.closeConnection(conn);
		}
	}

}
