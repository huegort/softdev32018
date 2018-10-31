package ie.gmit.week08.first;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;

import ie.gmit.week05.model.Book;

public class BookDao extends GenericDaoImpl<Book>{

	
	public BookDao() {
		super(Book.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book marshalEntity(ResultSet rs) throws SQLException {
		Book b = new Book();
		b.setIsbn(rs.getString("isbn"));
		b.setPrice(rs.getInt("price"));
		b.setDatePublished(rs.getDate("datePublished").toLocalDate());
		return b;
	}

	@Override
	void populatePs(PreparedStatement ps, Book entity) throws SQLException {
		ps.setString(1, entity.getIsbn());
		ps.setInt(2, entity.getPrice());
		ps.setObject(3, entity.getDatePublished());
		
	}
	@Override
	void populatePsId(PreparedStatement ps, Book entity) throws SQLException {
		ps.setString(4, entity.getIsbn());
		
	}

		
	@Override
	String getSets() {
		return " isbn=?, price = ?, datepublished = ? ";
	}
	@Override
	String getSetId() {
		// TODO Auto-generated method stub
		return " isbn = ? ";
	}

	

}
