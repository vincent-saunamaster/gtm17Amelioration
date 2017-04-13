package metier;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CONTACT_ID")
	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	// sauve et efface en cascade
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Adresse adresse;
	
	@ManyToMany
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
	@Override
	public String toString() {
		return "contact [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
}
