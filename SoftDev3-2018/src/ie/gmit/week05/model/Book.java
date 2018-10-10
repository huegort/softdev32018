package ie.gmit.week05.model;

import java.time.LocalDate;

public class Book {
	String isbn;
	LocalDate datePublished;
	int price;
	public Book() {
		
	}
	public Book(String isbn, LocalDate datePublished, int price) {
		super();
		this.isbn = isbn;
		this.datePublished = datePublished;
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public LocalDate getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datePublished == null) ? 0 : datePublished.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + price;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (datePublished == null) {
			if (other.datePublished != null)
				return false;
		} else if (!datePublished.equals(other.datePublished))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", datePublished=" + datePublished + ", price=" + price + "]";
	}
	
	
}
