package service;

import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Adresse;
import metier.Contact;

public class Service implements Iservice {

	private IDao x = new Dao();
	@Override
	public int ajouterAdresse(Adresse a) {
		// TODO Auto-generated method stub
		
		return x.ajouterAdresse(a);
	}

	@Override
	public int ajouterContactAdresse(Contact c, Adresse a) {
		// TODO Auto-generated method stub
		return x.ajouterContactAdresse(c, a);
	}

	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return x.modifierAdresse(a);
	}

	@Override
	public Collection<Contact> findAllContacts() {
		// TODO Auto-generated method stub
		return x.findAllContacts();
	}

	@Override
	public Adresse findAdresse(int id) {
		// TODO Auto-generated method stub
		return x.findAdresse(id);
	}

	@Override
	public void deleteAdresse(Adresse a) {
		// TODO Auto-generated method stub
		x.deleteAdresse(a);

	}

}
