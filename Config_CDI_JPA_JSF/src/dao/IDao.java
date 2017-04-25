package dao;

import java.util.Collection;

import metier.Client;

public interface IDao {
	public long addClient(Client c);
	public Collection<Client> listerClients();
	public Client findClient(long idclient);
	public void removeClient(Client c);
	public void modifierClient(Client c);
}
