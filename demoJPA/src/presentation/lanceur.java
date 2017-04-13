package presentation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.Contact;
import metier.LongMetrage;
import metier.Telefilm;

public class lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1: ouverture de l'unité de persistance (<persistence-unit
		// name="demojpa-pu"> dans persistence.xml)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();

		// 2: ouverture de la transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		// 3: création d'un objet métier
		Adresse s = new Adresse();
		s.setVille("Lyon");
		s.setNumRue("120 rue massena");
		s.setCodePostal("69006");
		
		Contact c = new Contact();
		c.setNom("toto");
		c.setPrenom("titi");
		c.setEmail("toto.titi@tata.com");
		
		LongMetrage lm = new LongMetrage();
		lm.setNomFilm("Film1");
		lm.setCinema("Gaumont");
		
		Telefilm tf = new Telefilm();
		tf.setChaine("arte");
		tf.setNomFilm("telefilm1");
		
		

		// 4: persistance de l'objet métier
		em.persist(c);
		em.persist(lm);
		em.persist(tf);
		
		// 5: validation de la transaction
		tx.commit();
		
		// 6 : fermeture de l'unité de persistance
		em.close();
		emf.close();
	}

}
