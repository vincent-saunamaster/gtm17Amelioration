package service;

import dao.Dao;

//import javax.inject.Inject;

import dao.IDao;
import metier.Client;

public class ServiceImp implements Iservice {
	//@Inject
	//private IDao dao;
	private IDao dao = new Dao();

	@Override
	public long addClient(Client c) {
		// TODO Auto-generated method stub
		return dao.addClient(c);
	}

}
