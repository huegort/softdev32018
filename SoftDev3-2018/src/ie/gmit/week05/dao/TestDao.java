package ie.gmit.week05.dao;

import java.time.LocalDate;

import ie.gmit.week05.model.Book;

public class TestDao {
	
	public static void main(String[] args) {
		Book b = new Book("wqert", LocalDate.now(),123);
		BookDao bookDao = new BookDao();
		
		bookDao.create(b);
	}
	
	

}
