package metier;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
// requete nommée, utilisable dans les autre classes (Classe.nom est purement cosmétique !!!)
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CONTACT_ID")
	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	// CascadeType sauve,efface,MàJ en cascade, FetchType change chargement en lazy ou eager
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	private Adresse adresse;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Collection<Film> films;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Collection<Film> getFilms() {
		return films;
	}
	public void setFilms(Collection<Film> films) {
		this.films = films;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresse=" + adresse
				+ "]";
	}

}
