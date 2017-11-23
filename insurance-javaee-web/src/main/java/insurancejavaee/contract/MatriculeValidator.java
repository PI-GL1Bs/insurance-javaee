package insurancejavaee.contract;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("matval")
public class MatriculeValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		
		String valeur = String.valueOf(value);
		String regex = "\\d{1,3} TUN \\d{1,4}";
		 if(!valeur.matches(regex)){
			 FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"La Matricule est invalide","");
	            throw new ValidatorException(msg);
		 }
	}

}
