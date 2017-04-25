package service;

import java.util.Collection;

import metier.Client;

public interface Iservice {
	public long addClient(Client c);
	public Collection<Client> listerClients();
	public void removeClient(Client c);
	public Client findClient(long idclient);
	public void modifierClient(Client c);

}
