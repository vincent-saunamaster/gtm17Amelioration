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
@ManagedBean(name = "bean1")
@RequestScoped
// nom de la classe => par défaut, celui de la classe métier
public class ClientBean implements Serializable {

	private static final long serialVersionUID = 1L;

	//private long id;
	//private String nom;
	//private String prenom;

	// placehoder
	private Client client = new Client();

	public Client getClient() {
		return client;
	}


	// getters et setters
	public long getId() {
		//return id;
		return client.getId();
	}

	public void setId(long id) {
		//this.id = id;
		this.getClient().setId(id);;
	}

	public String getNom() {
		//return nom;
		return client.getNom();
	}

	public void setNom(String nom) {
		//this.nom = nom;
		this.getClient().setNom(nom);
	}

	public String getPrenom() {
		//return prenom;
		return client.getPrenom();
	}

	public void setPrenom(String prenom) {
		//this.prenom = prenom;
		this.getClient().setPrenom(prenom);
	}

	// methode séparée qui communique avec couche service
	private static Iservice iserv = new ServiceImp();

	// la fonction du bouton qui envoie en BDD
	public String recupform1() {
		this.getClient().setId(iserv.addClient(this.getClient()));

		FacesMessage message = new FacesMessage(client.getId() + " crée en BDD !");
		FacesContext.getCurrentInstance().addMessage(null, message);

		return "recupFormulaire1";
	}

}
