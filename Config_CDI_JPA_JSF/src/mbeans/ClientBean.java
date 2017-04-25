package mbeans;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import metier.Client;
import service.Iservice;

//permet à CDI de mettre ce bean dans son conteneur (JSF géré par CDI !!!!)
@Named
@ViewScoped
public class ClientBean {

	@Inject
	Iservice iserv;

	private Client client = new Client();

	// dit si bouton add du formulaire est en modification ou ajout
	private boolean editmode = false;

	public boolean isEditmode() {
		return editmode;
	}

	public void setEditmode(boolean editmode) {
		this.editmode = editmode;
	}

	public Iservice getIserv() {
		return iserv;
	}

	public void setIserv(Iservice iserv) {
		this.iserv = iserv;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// méthodes du formulaire
	public void add() {
		if (!client.getNom().equalsIgnoreCase("") && !client.getPrenom().equalsIgnoreCase("")) {
			if (editmode == false) {
				iserv.addClient(client);
			} else {
				iserv.modifierClient(client);
				editmode = false;
			}
		} else {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("client", new FacesMessage(FacesMessage.SEVERITY_ERROR ,"veuillez saisir des valeurs non nulles", null));
		}

		client = new Client();
	}

	public Collection<Client> list() {
		Collection<Client> colcli = iserv.listerClients();
		return colcli;
	}

	public void remove() {
		iserv.removeClient(client);
		client = new Client();
	}

	public void modifier() {
		editmode = true;

	}
}
