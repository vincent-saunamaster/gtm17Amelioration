package presentation;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import interceptor.Interceptor2annotation;
import service.Iservice;
import service.ServiceImp;

public class lanceur {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1- chargement du container
		WeldContainer weld = new Weld().initialize();
		// 2- recupération du service
		Iservice service = weld.instance().select(ServiceImp.class).get();
		// 3- appel méthodes...
		String resultat = service.appelDao();
		System.out.println(resultat);
		// 4- destruction des objets
		weld.instance().destroy(service);

	}

}
