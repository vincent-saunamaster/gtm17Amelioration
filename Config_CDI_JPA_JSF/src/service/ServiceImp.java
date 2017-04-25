package service;

import java.util.Collection;

import javax.inject.Inject;

import dao.IDao;
import metier.Client;

public class ServiceImp implements Iservice {
	@Inject
	private IDao dao;

	@Override
	public long addClient(Client c) {
		// TODO Auto-generated method stub
		return dao.addClient(c);
	}

	@Override
	public Collection<Client> listerClients() {
		// TODO Auto-generated method stub
		return dao.listerClients();
	}

	@Override
	public void removeClient(Client c) {
		// TODO Auto-generated method stub
		dao.removeClient(c);
	}

	@Override
	public Client findClient(long idclient) {
		// TODO Auto-generated method stub
		return dao.findClient(idclient);
	}

	@Override
	public void modifierClient(Client c) {
		// TODO Auto-generated method stub
		dao.modifierClient(c);
	}

}
