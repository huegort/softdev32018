package ie.gmit.week10.GenericDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public abstract class GenericDaoImpl<T> implements GenericDAO<T> {
	protected final String url ="jdbc:mysql://localhost/its3";
	protected final String user = "root";
	protected final String password = "";
	
	
	protected abstract String getTableName();
	protected abstract long getId();
	protected abstract void setId(T entity,long id);
	protected abstract String[] getFieldNames();
	protected abstract T retrieveFromRS(ResultSet rs);
	protected abstract void populatePS(PreparedStatement ps);
	
	protected String getAllSQL;
	protected String findByIdSQL;
	protected String createSQL;
	protected String updateSQL;
	protected String deleteSQL;
	protected int numberOfFields;
	
	
	
	GenericDaoImpl(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		getAllSQL  	= "select * from "+getTableName()+" ;";
		findByIdSQL = "select * from "+getTableName()+" where id = ? ;";
		createSQL 	= "insert into "+getTableName()+" ("+getCreateFields()+") values ("+getCreateQMarks()+");";
		updateSQL 	= "update "+getTableName()+" set "+getUpdateFields() +" where id = ?";
		deleteSQL 	= "delete from  "+getTableName()+"  where id = ?";
		numberOfFields = getFieldNames().length;
	}
	protected String getCreateFields() {
		return String.join(",", getFieldNames());
		
	}
	protected String getCreateQMarks() {
		StringBuilder sb = new StringBuilder();
		sb.append("?");
		for (int i = 1; i< getFieldNames().length;i++) {
			sb.append(", ?");
			
		}
		return sb.toString();
		
	}
	protected String getUpdateFields() {
		StringBuilder sb = new StringBuilder();
		String names[] = getFieldNames();
		sb.append(names[0]+"= ? ");
		for (int i = 1; i< names.length;i++) {
			sb.append(","+ names[i]+"=? ");
		}
		return sb.toString();
		
		
	}
	protected Connection getConnection() {
		try {
			return DriverManager.getConnection(url,user, password);
		} catch (SQLException e) {
			System.out.println("no connection");
			throw new RuntimeException(e);
		}
		
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
	
	
	@Override
	public Set<T> getAll() {
		System.out.println(this.getAllSQL);
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(this.getAllSQL);
			ResultSet rs = ps.executeQuery();
			Set<T> entities = new HashSet<T>();
			while (rs.next()) {
				entities.add(retrieveFromRS(rs));
			}
			return entities;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			this.closeConnection(connection);
		}
	}

	@Override
	public T findById(long id) {
		System.out.println(this.findByIdSQL);
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(this.findByIdSQL);
			ps.setLong(1, getId());
			ResultSet rs = ps.executeQuery();
			T entity = null;
			if (rs.next()) {
				entity = retrieveFromRS(rs);
			}
			return entity;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			this.closeConnection(connection);
		}
	}
	

	@Override
	public long create(T entity) {
		System.out.println(this.createSQL);
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(this.createSQL,Statement.RETURN_GENERATED_KEYS	);
			this.populatePS(ps);
			 ps.executeUpdate();
			 ResultSet rs = ps.getGeneratedKeys();
             if(rs.next())
             {
            	 setId(entity, rs.getInt(1));
                 return rs.getInt(1);
             }
             throw new RuntimeException("no auto increment on table "+getTableName());
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			this.closeConnection(connection);
		}
	}
	
	

	@Override
	public void update(T entity) {
		System.out.println(updateSQL);
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(updateSQL	);
			this.populatePS(ps);
			ps.setLong(numberOfFields+1, getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			this.closeConnection(connection);
		}
	}


	@Override
	public void delete(long id) {
		System.out.println(deleteSQL);
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(deleteSQL	);
			ps.setLong(1, getId());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			this.closeConnection(connection);
		}
		
	}

}
