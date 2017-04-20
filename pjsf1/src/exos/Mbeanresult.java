package exos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mbeanresult", eager = true)
@SessionScoped
public class Mbeanresult {
	private String dataresult = "";

	public String getDataresult() {
		return dataresult;
	}

	public void setDataresult(String dataresult) {
		System.out.println("setting dataresult" + dataresult);
		this.dataresult = dataresult;
	}

	public Mbeanresult() {
		super();
	}

}
