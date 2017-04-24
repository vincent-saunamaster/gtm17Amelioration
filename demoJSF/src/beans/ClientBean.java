package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import metier.Client;
import service.Iservice;
import service.ServiceImp;

// ManagedBean => un simple bean, mais géré par JSF !
// par défaut, on l'appelle par le nom de sa classe, mais on peut changer avec "name"
@ManagedBean(name="bean1")
@RequestScoped
// nom de la classe => par défaut, celui de la classe métier
public class ClientBean implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Client client;
	
	// le getter de l'instance de la classe métier
	public Client getClient() {
		return client;
	}

	// le constructeur initialise une instance de sa classe métier
	public ClientBean() {
		Client cli = new Client();
		//cli.setNom(client.getNom());
		//cli.setPrenom(client.getPrenom());
	}
	
	// la fonction du bouton qui envoie en BDD
	public void recupform1() {
		Client cli = new Client();
		cli.setNom(client.getNom());
		cli.setPrenom(client.getPrenom());
		
		Iservice is = new ServiceImp();
		long id = is.addClient(cli);
		
		FacesMessage message = new FacesMessage( id + "crée en BDD !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
	}
	

	

}
