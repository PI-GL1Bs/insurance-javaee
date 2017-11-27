package isurancejavaee.user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import domain.Insured;
import domain.User;
import services.InsuredServiceLocal;
import services.UserServiceLocal;
@ManagedBean(name="AjoutBean")
@ViewScoped
public class AjoutInsuredBean {
	@EJB
	private UserServiceLocal userServiceLocal;

	@EJB
	private InsuredServiceLocal insuredService;
	@ManagedProperty("#{authBean}")
	private AuthentificationBean authBean ;
	private List <User>listUsers;
	private User user ;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Insured insured;
	private List<Insured> insureds;
	private boolean formDisplayed;
	private List<Insured> filteredInsured;
     private Boolean renderUpdateForm=false;

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}



	public AuthentificationBean getAuthBean() {
		return authBean;
	}

	public void setAuthBean(AuthentificationBean authBean) {
		this.authBean = authBean;
	}

	public AjoutInsuredBean() {
	}

	@PostConstruct
	public void init() {
		insured=new Insured();
		insureds = insuredService.findAllInsured();
		formDisplayed = false;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	public String doSignUp() {
		String navigateTo=null;
		insuredService.saveOrUpdate(insured);
		authBean.setUser(insured);
		navigateTo = authBean.doLogin();
		return navigateTo;
	}
	
	public void doDelete() {
		
		insuredService.removeUser(insured);
			
		listUsers = userServiceLocal.findAllUsers();
		formDisplayed=false;
		
	}

	public void doCancel() {
		formDisplayed = false;
	}
	
	public void onRowSelect() {
		formDisplayed = true;
	}
	
	public void onFilter(){
		insured = new Insured();
		formDisplayed = false;
	}

	

	

	public void validateLoginUnicity(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String loginToValidate = (String) value;
		if (loginToValidate == null || loginToValidate.trim().isEmpty()) {
			return;
		}
		boolean loginInUse = userServiceLocal.loginExists(loginToValidate);
		if (loginInUse) {
			throw new ValidatorException(new FacesMessage(
					"login already in use!"));
		}
	}

	public List<Insured> getInsureds() {
		return insureds;
	}

	public void setInsureds(List<Insured> insureds) {
		this.insureds = insureds;
	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}

	public List<Insured> getFilteredInsured() {
		return filteredInsured;
	}

	public void setFilteredInsured(List<Insured> filteredInsured) {
		this.filteredInsured = filteredInsured;
	}
	//public String updateInsured ()
	//{
	//	insuredService.modifyInsured(insured);
	//	return "User/back.jsf?faces-redirect=true";
	//}

	
	

}
