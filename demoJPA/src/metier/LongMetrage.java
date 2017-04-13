package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//héritage simple, seule la mère a une table
//@DiscriminatorValue("LONG")
//heritage par table jointe et concrete
public class LongMetrage extends Film {
	
	private String cinema;

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	

}
