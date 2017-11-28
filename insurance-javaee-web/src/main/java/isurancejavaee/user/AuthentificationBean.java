package isurancejavaee.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import domain.Admin;
import domain.Insured;
import domain.User;
import services.UserServiceLocal;
@ManagedBean(name="AuthBean")
@SessionScoped
public class AuthentificationBean implements Serializable{
	private static final long serialVersionUID = -6916676537171647179L;

	@EJB
	private UserServiceLocal authenticationServiceLocal;

	// model
	private User user;
	private boolean loggedIn;
	private boolean DoLogOut;
	public boolean isDoLogOut() {
		return DoLogOut;
	}

	public void setDoLogOut(boolean doLogOut) {
		DoLogOut = doLogOut;
	}

	public AuthentificationBean() {
		
	}
		
	@PostConstruct
	public void initModel() {
		user = new User();
		loggedIn = false;
		DoLogOut=true;
	}

	public String doLogin() {
		String navigateTo = null;
		// login application logic
		User found = authenticationServiceLocal.authenticate(user.getLogin(),
				user.getPassword());
		if (found != null) {
			user = found;
			loggedIn = true;
			DoLogOut=false;
			if (user instanceof Admin) {
				navigateTo = "/User/back?faces-redirect=true";
			}
			if (user instanceof Insured) {
				authenticationServiceLocal.updateInc(user.getLogin(), user.getPassword());
				navigateTo = "/contract/addcontract?faces-redirect=true";
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(
					"login_form:login_submit",
					new FacesMessage("Bad credentials!"));
		}
		return navigateTo;
	}

	public String doLogout() {
		String navigateTo = null;
		initModel();
		navigateTo = "/template/template.jsf?faces-redirect=true";
		return navigateTo;
	}

	public boolean hasRole(String role) {
		boolean authorized = false;
		if (role.equals("Admin")) {
			authorized = (user instanceof Admin);
		}
		if (role.equals("Insured")) {
			authorized = (user instanceof Insured);
		}

		return authorized;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


}
