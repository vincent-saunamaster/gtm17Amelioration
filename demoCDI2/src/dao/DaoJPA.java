package dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import dao.NotificationTypeDao.TypeDAO;

@NotificationTypeDao(TypeDAO.JPA)
public class DaoJPA implements IDao {

	@Override
	public String appelDao() {
		// TODO Auto-generated method stub
		return "Bonjour, c'est bien la JPA ici";
	}
	@PostConstruct
	public void logApresConstruction(){
		System.out.println("Après création JPA");
	}
	
	@PreDestroy
	public void logApresDestruction(){
		System.out.println("avant destruction JPA");
	}

}
