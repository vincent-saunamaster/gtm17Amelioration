package dao;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Client;

public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpacdi-pu");

	@Override
	public long addClient(Client c) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		return c.getId();
	}

	@Override
	public Collection<Client> listerClients() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Query q = em.createQuery("SELECT c FROM Client c");
		Collection<Client> l = (Collection<Client>) q.getResultList();

		em.close();
		return l;
	}

	@Override
	public Client findClient(long id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = (Query) em.find(Client.class, id);
		Client c = (Client) q.getSingleResult();
		System.out.println(c.getNom());
		tx.commit();
		em.close();

		return c;
	}

	@Override
	public void removeClient(Client c) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//faut vérifier que l'objet n'est pas détaché sinon on l'attache avant de le supprimer
		em.remove(em.contains(c) ? c : em.merge(c));
		//em.remove(em.find(Client.class, c.getId()));
		tx.commit();
		em.close();
	}

	@Override
	public void modifierClient(Client c) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
	}

}
