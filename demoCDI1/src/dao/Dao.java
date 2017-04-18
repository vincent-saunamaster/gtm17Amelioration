package dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dao implements IDao {

	@Override
	public String appelDao() {
		// TODO Auto-generated method stub
		return "Bonjour, c'est bien la Dao ici";
	}

	@PostConstruct
	public void logApresConstruction(){
		System.out.println("Après création dao");
	}
	
	@PreDestroy
	public void logApresDestruction(){
		System.out.println("avant destruction dao");
	}
	
	
}
