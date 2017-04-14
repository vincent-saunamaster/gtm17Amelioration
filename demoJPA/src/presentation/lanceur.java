package presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Adresse;
import metier.Contact;
import metier.CourtMetrage;
import metier.Film;
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
		c.setAdresse(s);
		
		
		LongMetrage lm = new LongMetrage();
		lm.setNomFilm("Longmetrage1");
		lm.setCinema("Gaumont");
		
		Telefilm tf = new Telefilm();
		tf.setChaine("arte");
		tf.setNomFilm("telefilm1");
		
		CourtMetrage cm = new CourtMetrage();
		cm.setBenevole(10);
		cm.setNomFilm("courmetrage1");
		
		Collection<Film> colfilm = new ArrayList<Film>();
		colfilm.add(lm);
		colfilm.add(tf);
		colfilm.add(cm);
		c.setFilms(colfilm);

		// 4: persistance de l'objet métier
		// ajout par requête
		em.persist(c);
		em.persist(lm);
		em.persist(tf);
		em.persist(cm);
		
		// 5: validation de la transaction
		System.out.println(c);
		System.out.println(s);
		tx.commit();
		
		
		
		//recuperer le film par requete de lecture avec find(classeAchercher, numéroPKduFilm)
		Film f = em.find(Film.class, 3);
		System.out.println(f);
		
		//update par requete, nécessite nouvelle transaction
		f.setNomFilm("filmupdaté");
		tx.begin();
		em.merge(f);
		tx.commit();
		
		//suppression par requete,
		tx.begin();
		// 0- récupérer l'objet (à jour en base) qu'on veut supprimer
		//Film f = em.find(Film.class, 3);
		// 1- récupérer les objets (à jour en base) liés à celui qu'on veut supprimer
		c = em.find(Contact.class, 1);
		// 2- retirer l'attribut à supprimer des objets liés
		c.getFilms().remove(f);
		// 3- mettre ces objets liés (et à jour) en base
		em.merge(c);
		// 4- on peut enfin effacer l'objet désiré de la base
		em.remove(f);
		tx.commit();
		
		//recherche simple de tous les  flims en bdd
		Collection<Film> listeFilm = em.createQuery("SELECT aliasfilm FROM Film aliasfilm").getResultList();
		for (Film f1 : listeFilm) {
			System.out.println(f1);
		}
		
		//recherche avec parametres des films d'un certain nom
		Query q = em.createQuery("SELECT aliasfilm FROM Film aliasfilm WHERE aliasfilm.nomFilm = :leNom");
		q.setParameter("leNom", "telefilm1");
		Collection<Film> listeFilm2 = q.getResultList(); 
		for (Film f1 : listeFilm2) {
			System.out.println(f1);
		}
		
		//recherche avec parametres des films contenant un certain mot ou lettre
		Query q2 = em.createQuery("SELECT aliasfilm FROM Film aliasfilm WHERE aliasfilm.nomFilm like :leNom");
		q2.setParameter("leNom", "%1%");
		Collection<Film> listeFilm3 = q2.getResultList(); 
		for (Film f1 : listeFilm3) {
			System.out.println(f1);
		}
		
		//recherche d'un résultat unique
		Film filmseul = (Film) em.createQuery("SELECT alias from Film alias where alias.id_film=2").getSingleResult();
		System.out.println(filmseul);
		
		//exemple de jointures entre Contact et Adresse (c.adresse pointe sur la Classe Adresse !!!)
		Query q3 = em.createQuery("SELECT c FROM Contact c left join c.adresse");
		List<Contact> listContact = q3.getResultList();
		for (Contact cx : listContact) {
			System.out.println(cx);
		}
		
		//appel d'une requete nommée
		Query q4 = em.createNamedQuery("Contact.findAll");
		List<Contact> listContact2 = q4.getResultList();
		for (Contact cx : listContact2) {
			System.out.println(cx);
		}
		
		Query q5 = em.createNamedQuery("Adresse.findAll");
		List<Adresse> listAdresse = q5.getResultList();
		for (Adresse a : listAdresse) {
			System.out.println(a);
		}
		
		Query q6 = em.createNamedQuery("Adresse.findLettreouMot");
		q6.setParameter("etiquette", "%0%");
		List<Adresse> listAdresse2 = q6.getResultList();
		for (Adresse a : listAdresse2) {
			System.out.println(a);
		}
		
		// 6 : fermeture de l'unité de persistance
		em.close();
		emf.close();
	}

}
