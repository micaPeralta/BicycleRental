package daos;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEM {

	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("jaa2017");
	public static EntityManagerFactory getEMF() {
		return em;
		}
	}
