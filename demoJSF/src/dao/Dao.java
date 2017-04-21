package dao;
/*
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
*/
import metier.Client;

public class Dao implements IDao {

//	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpacdi-pu");
	
	@Override
	public long addClient(Client c) {
		// TODO Auto-generated method stub
		/*
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();*/
		//return c.getId();
		return 1l;
		
	}

}
