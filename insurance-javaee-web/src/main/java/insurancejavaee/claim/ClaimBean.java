package insurancejavaee.claim;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import domain.*;
import services.*;

@ManagedBean
@SessionScoped
public class ClaimBean {
	@EJB
	private ClaimMangmentLocal claimMangmentLocal;
	static private Claim claim = new Claim();
	private List<Claim> listClaims = new ArrayList<Claim>();

	private boolean formDisplayed=true;
	private boolean formDisplayed1;
	private boolean formDisplayed2;
	private boolean formDisplayed3;
	private boolean formDisplayed4;
	private boolean formDisplayed5;
	private boolean formDisplayed6;
	@PostConstruct
	public void init() {
		//test();
		listClaims = claimMangmentLocal.findAllClaims();
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
		
		
		return "/ClaimPages/Estimation?faces-redirect=true";
	}

	public String doSave() {
	
		claimMangmentLocal.addClaim(claim);
		init();
		return "/ClaimPages/Claim?faces-redirect=true";
	}

	public String navCreate() {
		this.claim = new Claim();
		claim.setStatus("not treated yet");
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
	

}