package ie.gmit.week08.first;

import java.time.LocalDate;

import ie.gmit.week05.model.Book;

public class MainA {

	public static void main(String[] args) {
		System.out.println("hello");
		GenericDao<Book> dao = new BookDao();
		
		Book book = new Book("yo",LocalDate.now(), 1000);
		dao.update(book);
		
		for (Book b :dao.getAll()) {
			System.out.println(b);
		}

	}

}
