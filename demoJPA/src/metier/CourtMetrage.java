package metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//héritage simple, seule la mère a une table
@DiscriminatorValue("COURT")
//heritage par table jointe et concrete
public class CourtMetrage extends Film {

	private int benevole;

	public int getBenevole() {
		return benevole;
	}

	public void setBenevole(int benevole) {
		this.benevole = benevole;
	}

	@Override
	public String toString() {
		return "CourtMetrage [benevole=" + benevole + ", toString()=" + super.toString() + "]";
	}
	
}
