package ie.gmit.week10.GenericDAO;

import java.util.Set;

public interface GenericDAO<T> {
	public Set<T> getAll();
	public T findById(long id);
	public long create(T entity);
	public void update(T entity);
	public void delete(long id);
}
