package ie.gmit.week08.first;

import java.util.Set;

import ie.gmit.week05.model.Book;

public interface GenericDao<T> {
	public Set<T> getAll();
	public void update(T entity);
	
}
