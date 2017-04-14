package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Adresse;
import metier.Contact;

public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");

	@Override
	public int ajouterAdresse(Adresse a) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(a);
		tx.commit();
		em.close();
		return a.getId();
	}

	@Override
	public int ajouterContactAdresse(Contact c, Adresse a) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		c.setAdresse(a);
		em.persist(c);
		tx.commit();
		em.close();
		return c.getId();
	}

	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(a);
		tx.commit();
		em.close();
		return a.getId();
	}

	@Override
	public Collection<Contact> findAllContacts() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = em.createNamedQuery("Contact.findAll");
		Collection<Contact> l = q.getResultList();
		tx.commit();
		em.close();

		return l;
	}

	@Override
	public Adresse findAdresse(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query q = em.createQuery("SELECT alias from Adresse alias where alias.id=:etiquette");
		q.setParameter("etiquette", id);
		Adresse a = (Adresse) q.getSingleResult();
		tx.commit();
		em.close();

		return a;
	}

	@Override
	public void deleteAdresse(Adresse a) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		// 0- récupérer l'objet (à jour en base) qu'on veut supprimer
		Adresse adr = em.find(Adresse.class, a.getId());
		// 1- récupérer les objets (à jour en base) liés à celui qu'on veut
		// supprimer
		for (Contact c : adr.getContacts()) {
			Contact cx = em.find(Contact.class, c.getId());
			// 2- retirer l'attribut à supprimer des objets liés
			cx.setAdresse(null);
			// 3- mettre ces objets liés (et à jour) en base
			em.merge(cx);
		}
		// 4- on peut enfin effacer l'objet désiré de la base
		em.remove(adr);
		tx.commit();
		em.close();
	}

}
