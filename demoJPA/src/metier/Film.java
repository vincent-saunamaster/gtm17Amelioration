package metier;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
// héritage simple, seule la mère a une table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_FILM")
// heritage par table concrete
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//heritage par table jointe
//@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Film {

	@Id
	// héritage simple, seule la mère a une table
	//@GeneratedValue(strategy=GenerationType.AUTO)
	// heritage par table concrete
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="FILM_ID")
	private int id_film;
	private String nomFilm;
	
	// dans le cas ManyToMany, on choisit un esclave (mappedBy="l'attribut de la classe maitre")
	@ManyToMany(mappedBy="films")
	private Collection<Contact> contacts;
	public int getId_film() {
		return id_film;
	}
	public void setId_film(int id_film) {
		this.id_film = id_film;
	}
	public String getNomFilm() {
		return nomFilm;
	}
	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}
	@Override
	public String toString() {
		return "Film [id_film=" + id_film + ", nomFilm=" + nomFilm + "]";
	}
}
