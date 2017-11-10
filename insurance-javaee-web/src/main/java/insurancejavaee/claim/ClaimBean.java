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
	private Claim claim = new Claim();
	private List<Claim> listClaims = new ArrayList<Claim>();
	private boolean formDisplayed;

	@PostConstruct
	public void init() {
		listClaims = claimMangmentLocal.findAllClaims();
	}

	public ClaimBean() {
	}

	public String navToClaim() {
		return "/ClaimPages/Claim?faces-redirect=true";
	}
	public String navToClaimAdmin() {
		claim.setStatus("during treatment");
		claimMangmentLocal.addClaim(claim);
		return "/ClaimAdminPages/ClaimAdmin?faces-redirect=true";
	}
	public String ValideAction() {
		if((claim.getStatus()).equals("Accept")){
			claim.setStatus("Accepted");
		}else if((claim.getStatus()).equals("Reject")){
			claim.setStatus("Rejected");
		}
		claimMangmentLocal.addClaim(claim);
		return "/ClaimAdminPages/ClaimsListAdmin?faces-redirect=true";
	}
	public String doSave() {
		claimMangmentLocal.addClaim(claim);
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
		return "";
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

}