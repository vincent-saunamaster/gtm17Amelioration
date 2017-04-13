package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//héritage simple, seule la mère a une table
//@DiscriminatorValue("TELEFILM")
//heritage par table jointe et concrete
public class Telefilm extends Film {

	private String chaine;

	public String getChaine() {
		return chaine;
	}

	public void setChaine(String chaine) {
		this.chaine = chaine;
	}
	
	
}
