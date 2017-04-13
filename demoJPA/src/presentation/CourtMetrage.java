package presentation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import metier.Film;

@Entity
//héritage simple, seule la mère a une table
//@DiscriminatorValue("COURT-METRAGE")
//heritage par table jointe et concrete
public class CourtMetrage extends Film {

	private int benevole;
}
