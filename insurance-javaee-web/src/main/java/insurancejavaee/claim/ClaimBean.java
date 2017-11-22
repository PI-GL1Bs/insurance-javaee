package insurancejavaee.claim;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Path;

import domain.*;
import services.*;

@ManagedBean
@SessionScoped

public class ClaimBean {
	private boolean formDisplayedes=false;
	private boolean formDisplayedes2=false;
	private boolean formDisplayedes3=true;
	private boolean formDisplayedes4;
	private boolean formDisplayedes5;
	
	private boolean formDisplayed=true;
	private boolean formDisplayed1;
	private boolean formDisplayed2;
	private boolean formDisplayed3;
	private boolean formDisplayed4;
	private boolean formDisplayed5;
	private boolean formDisplayed6;
	@EJB
	private EstimationServiceLocal estimationServiceLocal;
	@EJB
	private ClaimMangmentLocal claimMangmentLocal;
 private Claim claim = new Claim();
	private List<Claim> listClaims = new ArrayList<Claim>();
	private Estimation estimation = new Estimation();
	

	@PostConstruct
	
	public void init() {
		//test();
		listClaims = claimMangmentLocal.findAllClaims();
	}
public void damagePositionSave(String s ){
		
		claim.setDamagePostion(claim.getDamagePostion() + " / " + s);
	}
	public void test(){
		formDisplayed1=false;
		formDisplayed2=false;
		formDisplayed3=false;
		formDisplayed5=false;
		formDisplayed6=false;
		if((claim.getStatus()).equals("Accepted"))
			formDisplayed1=true;
		else   if((claim.getStatus()).equals("not treated yet")){
			formDisplayed2=true;formDisplayed3=true;}
		else   if((claim.getStatus()).equals("not treated yet")||(claim.getStatus()).equals("during treatment"))
			formDisplayed3=true;
		else   if((claim.getStatus()).equals("Rejected")){
			formDisplayed5=true;}
		else   if((claim.getStatus()).equals("during treatment")){
			formDisplayed6=true;}
	}
	public ClaimBean() {
	}
	
	public void testFinalResult(){
		if((claim.getEstimation().getResult()).equals("buy a new car or repaire the old one")){
			formDisplayedes5=true;
		}
	}
	public void saveClaim(){
		claimMangmentLocal.addClaim(claim);
	}

	public String navToClaim() {
		test();
		return "/ClaimPages/Claim?faces-redirect=true";
	}
	public String navToClaimAdmin() {
		test();
		if((claim.getStatus()).equals("not treated yet"))
		claim.setStatus("during treatment");
		claimMangmentLocal.addClaim(claim);
		return "/ClaimAdminPages/ClaimAdmin?faces-redirect=true";
	}
	public String ValideAction() {
		String navto="";
		if((claim.getStatus()).equals("Accept")){
			claim.setStatus("Accepted");
			estimation=new Estimation();
			navto="/ClaimAdminPages/Estimation?faces-redirect=true";
		}else if((claim.getStatus()).equals("Reject")){
			claim.setStatus("Rejected");
			

			navto="/ClaimAdminPages/ClaimsListAdmin?faces-redirect=true";
		}
		claimMangmentLocal.addClaim(claim);
		formDisplayed=false;
		return navto;
		
	}
	public String NavtoDetails() {
		
		testFinalResult();
		return "/ClaimPages/Estimation?faces-redirect=true";
	}

	
	public String doSave() {
		
		claim.setStatus("not treated yet");
		claimMangmentLocal.addClaim(claim);
		test();
		init();
		return "/ClaimPages/Claim?faces-redirect=true";
	}

	public String navCreate() {
		this.claim = new Claim();
	
		return "/ClaimPages/FormClaim?faces-redirect=true";

	}

	public String navUpdate() {
		return "/ClaimPages/FormClaim?faces-redirect=true";

	}

	public String doDelete() {
		claimMangmentLocal.deleteClaim(claim);
		init();
		return "/ClaimPages/listClaims?faces-redirect=true";
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public String doNew() {
		formDisplayed = true;
		return "";
	}

	public String doCancel() {
		formDisplayed = false;
		return "";
	}

	public ClaimMangmentLocal getClaimMangmentLocal() {
		return claimMangmentLocal;
	}

	public void setClaimMangmentLocal(ClaimMangmentLocal claimMangmentLocal) {
		this.claimMangmentLocal = claimMangmentLocal;
	}

	public List<Claim> getListClaims() {
		return listClaims;
	}

	public void setListClaims(List<Claim> listClaims) {
		this.listClaims = listClaims;
	}

	public boolean isFormDisplayed() {
		return formDisplayed;
	}

	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public boolean isFormDisplayed1() {
		return formDisplayed1;
	}
	public void setFormDisplayed1(boolean formDisplayed1) {
		this.formDisplayed1 = formDisplayed1;
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
	public boolean isFormDisplayed6() {
		return formDisplayed6;
	}
	public void setFormDisplayed6(boolean formDisplayed6) {
		this.formDisplayed6 = formDisplayed6;
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
		else {estimation.setResult("buy a new car or repaire the old one");}
		formDisplayedes4=true;
	
		
	}
	public String toList(){
		
		return "/ClaimAdminPages/ClaimsListAdmin?faces-redirect=true";
	}
	public String doSavees(){
	
		
		estimationServiceLocal.saveEstimation(estimation);
		
		claim.setEstimation(estimation);
		saveClaim();
		formDisplayedes4=true;
		this.estimation=new Estimation();
		return "/ClaimAdminPages/ClaimsListAdmin?faces-redirect=true";
	}
	public String updateEstimation(){
		estimationServiceLocal.saveEstimation(estimation);
		formDisplayedes5=false;
		return "/ClaimAdminPages/ClaimAdmin?faces-redirect=true";
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