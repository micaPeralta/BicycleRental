package daos;

import java.util.List;

public interface GenericDAO<T> {

	public T find(int id );

	public void remove(T t);

	public T update(T t);

	public void persist(T t);

	//public int countAll();

	public List<T> list(String entity);
}
