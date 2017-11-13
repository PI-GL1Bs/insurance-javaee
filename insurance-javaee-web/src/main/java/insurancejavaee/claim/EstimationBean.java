package insurancejavaee.claim;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import domain.Claim;
import domain.Estimation;
import services.EstimationServiceLocal;

@ManagedBean
@ViewScoped
public class EstimationBean {

	@EJB
	private EstimationServiceLocal estimationServiceLocal;
	
	
	//ClaimBean CB =new ClaimBean();
 private Estimation estimation = new Estimation();
	private boolean formDisplayed=false;
	private boolean formDisplayed2=false;
	private boolean formDisplayed3=true;
	private boolean formDisplayed4;
	private boolean formDisplayed5=true;
	ClaimBean cb=new ClaimBean();
	@PostConstruct
	public void init() {
	
	}

	public void doSCalculeWorkForce(){
		formDisplayed=true;
		estimation.setPriceWorkForce(estimation.getElectricity()+estimation.getMechanical()+estimation.getPainting()+estimation.getWoodwork()+estimation.getSheetMetalWorkshop()+estimation.getTapestry());
	}
	public void doCalculClaimValue(){
		formDisplayed2=true;
		estimation.setValueClam(estimation.getValueBefore()-estimation.getValueAfter());
		
	}
	public void doResultEstimation(){
		
		if(estimation.getValueClam()<estimation.getPriceWorkForce()){
		estimation.setResult("by new auto");	
		}else if (estimation.getValueClam()>estimation.getPriceWorkForce()){
			estimation.setResult("repaire this Auto");	
}
		else estimation.setResult("you can buy a new car or repaire the old one an Email has been sent to the client to decide");
		formDisplayed4=true;
	
		
	}
	public String toList(){
		
		return "/ClaimAdminPages/ClaimsListAdmin?faces-redirect=true";
	}
	public String doSave(){
	estimation.setClaim(cb.getClaim());
		
		estimationServiceLocal.saveEstimation(estimation);
		cb.setClaim(new Claim());
		formDisplayed4=true;
		this.estimation=new Estimation();
		return "/ClaimAdminPages/ClaimsListAdmin?faces-redirect=true";
	}
	public EstimationBean() {
		super();
	}
	public EstimationServiceLocal getEstimationServiceLocal() {
		return estimationServiceLocal;
	}
	public void setEstimationServiceLocal(EstimationServiceLocal estimationServiceLocal) {
		this.estimationServiceLocal = estimationServiceLocal;
	}
	public Estimation getEstimation() {
		return estimation;
	}
	public void setEstimation(Estimation estimation) {
		this.estimation = estimation;
	}
	public boolean isFormDisplayed() {
		return formDisplayed;
	}
	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public boolean isFormDisplayed2() {
		return formDisplayed2;
	}
	public void setFormDisplayed2(boolean formDisplayed2) {
		this.formDisplayed2 = formDisplayed2;
	}
	public boolean isFormDisplayed3() {
		return formDisplayed3;
	}
	public void setFormDisplayed3(boolean formDisplayed3) {
		this.formDisplayed3 = formDisplayed3;
	}
	public boolean isFormDisplayed4() {
		return formDisplayed4;
	}
	public void setFormDisplayed4(boolean formDisplayed4) {
		this.formDisplayed4 = formDisplayed4;
	}
	public boolean isFormDisplayed5() {
		return formDisplayed5;
	}
	public void setFormDisplayed5(boolean formDisplayed5) {
		this.formDisplayed5 = formDisplayed5;
	}
	
	
}
