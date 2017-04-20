package exos;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbclients", eager = true)
@SessionScoped
public class MBClients {

	private ArrayList<Client> clients = new ArrayList<Client>();
	
	// faut pas que ça puisse retourner du null
	private Client clientCourant = new Client();

	// getters/setters
	public Client getClientCourant() {
		return clientCourant;
	}

	public void setClientCourant(Client clientCourant) {
		this.clientCourant = clientCourant;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	// constructeur
	public MBClients() {
		super();

	}

	// méthodes
	public int getNb() {
		return clients.size();
	}

	public String select(Client client) {
		this.clientCourant = client;
		System.out.println("selected " + clientCourant.getNom());
		return "clients2";
	}

	public String delete() {
		this.clients.remove(clientCourant);
		System.out.println("deleting : " + clientCourant.getNom());
		return "clients";
	}

	public String ajout() {
		// on cree un client vide
		Client x = new Client();
		// qu'on met à jour avec les nouvelles valeurs de clientCourant (issues du formulaire)
		x.setNom(clientCourant.getNom());
		x.setPrenom(clientCourant.getPrenom());
		// on ajoute ce nouveau client à la liste
		this.clients.add(x);
		// on restaure le clientCourant à vide
		clientCourant = new Client();
		System.out.println("adding: " + x.getNom());
		return "clients";
	}

}
