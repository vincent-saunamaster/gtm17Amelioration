package metier;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
//NamedQueries contient une liste de @NamedQuery
@NamedQueries({ @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a"),
		@NamedQuery(name = "Adresse.findLettreouMot", query = "SELECT a FROM Adresse a WHERE a.numRue LIKE :etiquette") })
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADRESSE_ID")
	private int id;
	private String numRue;
	private String codePostal;
	private String ville;
	@Transient
	private String Commentaire;
	// on choisit un esclave avec mappedBy="l'attribut de la classe maitre"
	@OneToMany(mappedBy = "adresse", fetch = FetchType.LAZY)
	private Collection<Contact> contacts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumRue() {
		return numRue;
	}

	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getCommentaire() {
		return Commentaire;
	}

	public void setCommentaire(String commentaire) {
		Commentaire = commentaire;
	}

	public Collection<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Collection<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", numRue=" + numRue + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", Commentaire=" + Commentaire + "]";
	}

}
