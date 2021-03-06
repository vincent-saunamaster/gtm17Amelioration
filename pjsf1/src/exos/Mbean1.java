package exos;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbean1", eager = true)
@SessionScoped
public class Mbean1 {
	private String message = "hello";
	private int compteur = 0;
	final static int CONSTANTE = 10;
	private String data;
	private String data2;

	public String getLesDeux() {
		return data + data2;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		System.out.println("setting data2 : " + data2);
		this.data2 = data2;
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage("laForm:inputdata2", new FacesMessage("le message ajouté à inputdata2 depuis le bean"));
		ctx.addMessage("laForm:inputdata3", new FacesMessage("le message ajouté à inputdata3 depuis le bean"));
		ctx.addMessage(null, new FacesMessage("le message ajouté à null depuis le bean"));
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		System.out.println("setting data : " + data);
		this.data = data;
	}

	public String getMessage() {
		compteur++;
		return message + compteur + " data = " + data + " data2 = " + data2;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Mbean1() {
		System.out.println("constructeur mbean1");
	}

	public String goConditionnel() {
		if (data.length() > 10)
			return "jsf3result2";
		else
			return "jsf3result";
	}

	public String testerreur() {
		System.out.println("testerreur");
			return "erreur";
	}

}
