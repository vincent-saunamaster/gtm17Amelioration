package exos;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("exos.ValidatorPerso")
public class ValidatorPerso implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object nomObjet) throws ValidatorException {
		// TODO Auto-generated method stub

		//test de validation
		if(!nomObjet.toString().contains("ok")){
			//on cree le message à afficher
			FacesMessage msg = new FacesMessage("y'a que 'ok' qui passe");
			// on définit (optionnellement) un niveau de sévérité 
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			// on balance le message
			throw new ValidatorException(msg);
		}
	}

}
