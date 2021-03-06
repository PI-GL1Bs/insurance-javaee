package insurancejavaee.reclamation;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import domain.Claim;
import domain.Insured;
import domain.Reclamation;
import domain.Reunion;
import services.InsuredServiceLocal;
import services.ReclamationServiceLocal;

@ManagedBean
@SessionScoped
public class ReclamationBean {

	@EJB
	ReclamationServiceLocal catalog;

	@EJB
	InsuredServiceLocal catalogInsured;

	private Reclamation reclamation = new Reclamation();
	private List<Reclamation> reclamations;

	public ReclamationBean() {
	}

	@PostConstruct
	public void init() {
		reclamation = new Reclamation();
		reclamations = catalog.findAll();
	}

	public String doSave() {

//		if (reclamation.getInsured() == null) {
//			Insured i = new Insured();
//			catalogInsured.saveOrUpdate(i);
//			reclamation.setInsured(i);
//		}

		if (reclamation.getStatus() == null) {
			reclamation.setStatus("pending");
		}
		reclamation.setDateTime(new Date());
		catalog.save(reclamation);
		reclamations = catalog.findAll();
		return "/reclamation/reclamations?faces-redirect=true";
	}

	public void doDelete() {
		catalog.delete(reclamation);
		reclamations = catalog.findAll();
	}

	public String doUpdate() {
		return "/reclamation/addReclamation?faces-redirect=true";

	}

	public String navCreate() {
		this.reclamation = new Reclamation();
		return "/reclamation/addReclamation?faces-redirect=true";
	}

	public Reclamation getReclamation() {
		return reclamation;
	}

	public void setReclamation(Reclamation reclamation) {
		this.reclamation = reclamation;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}
}
