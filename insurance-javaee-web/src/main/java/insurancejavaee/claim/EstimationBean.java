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
	private boolean formDisplayedes=false;
	private boolean formDisplayedes2=false;
	private boolean formDisplayedes3=true;
	private boolean formDisplayedes4;
	private boolean formDisplayedes5=true;
	ClaimBean cb=new ClaimBean();
	@PostConstruct
	public void init() {
	
	}

	public void doSCalculeWorkForce(){
		formDisplayedes=true;
		estimation.setPriceWorkForce(estimation.getElectricity()+estimation.getMechanical()+estimation.getPainting()+estimation.getWoodwork()+estimation.getSheetMetalWorkshop()+estimation.getTapestry());
	}
	public void doCalculClaimValue(){
		formDisplayedes2=true;
		estimation.setValueClam(estimation.getValueBefore()-estimation.getValueAfter());
		
	}
	public void doResultEstimation(){
		
		if(estimation.getValueClam()<estimation.getPriceWorkForce()){
		estimation.setResult("by new auto");	
		}else if (estimation.getValueClam()>estimation.getPriceWorkForce()){
			estimation.setResult("repaire this Auto");	
}
		else estimation.setResult("you can buy a new car or repaire the old one an Email has been sent to the client to decide");
		formDisplayedes4=true;
	
		
	}
	public String toList(){
		
		return "/ClaimAdminPages/ClaimsListAdmin?faces-redirect=true";
	}
	public String doSavees(){
	
		
		estimationServiceLocal.saveEstimation(estimation);
		
		cb.getClaim().setEstimation(estimation);
		cb.saveClaim();
		formDisplayedes4=true;
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
	public boolean isformDisplayedes() {
		return formDisplayedes;
	}
	public void setformDisplayedes(boolean formDisplayedes) {
		this.formDisplayedes = formDisplayedes;
	}
	public boolean isformDisplayedes2() {
		return formDisplayedes2;
	}
	public void setformDisplayedes2(boolean formDisplayedes2) {
		this.formDisplayedes2 = formDisplayedes2;
	}
	public boolean isformDisplayedes3() {
		return formDisplayedes3;
	}
	public void setformDisplayedes3(boolean formDisplayedes3) {
		this.formDisplayedes3 = formDisplayedes3;
	}
	public boolean isformDisplayedes4() {
		return formDisplayedes4;
	}
	public void setformDisplayedes4(boolean formDisplayedes4) {
		this.formDisplayedes4 = formDisplayedes4;
	}
	public boolean isformDisplayedes5() {
		return formDisplayedes5;
	}
	public void setformDisplayedes5(boolean formDisplayedes5) {
		this.formDisplayedes5 = formDisplayedes5;
	}
	
	
}
