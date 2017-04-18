package dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import dao.NotificationTypeDao.TypeDAO;

@NotificationTypeDao(TypeDAO.JDBC)
public class Dao implements IDao {

	@Override
	public String appelDao() {
		// TODO Auto-generated method stub
		return "Bonjour, c'est bien la JDBC ici";
	}

	@PostConstruct
	public void logApresConstruction(){
		System.out.println("Après création JDBC");
	}
	
	@PreDestroy
	public void logApresDestruction(){
		System.out.println("avant destruction JDBC");
	}
	
	
}
