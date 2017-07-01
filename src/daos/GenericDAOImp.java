package daos;
import daos.FactoryEM;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract  class GenericDAOImp<T> implements GenericDAO<T> {

	private Class<T> type;
	protected EntityManager entityManager;


	public GenericDAOImp() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class)pt.getActualTypeArguments()[0];
		EntityManagerFactory emf = FactoryEM.getEMF();
		this.entityManager=emf.createEntityManager();
	}


	@Override
	public void remove(Long id) {

		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		this.entityManager.remove( this.entityManager.getReference(type, id));
		tx.commit();
	}




	@Override
	public void persist(T t){
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		this.entityManager.persist(t);
		this.entityManager.flush();
		tx.commit();
	}

	@Override
	public T update(T t) {
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();
		 this.entityManager.merge(t);
		tx.commit();
		return null;
	}

	@Override
	public T find(Long id){
		EntityTransaction tx = this.entityManager.getTransaction();
		T resul = (T) this.entityManager.find(type, id);
		return resul;
	}

	public List<T> list(String entidad) {
		return this.entityManager.createQuery("select e from"+" "+entidad+" "+"e").getResultList();
	}
	
	




}
