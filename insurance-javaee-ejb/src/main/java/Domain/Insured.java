package Domain;

import Domain.User;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Insured
 *
 */
@Entity
@DiscriminatorValue("insured")
public class Insured extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="insured")
	private List<SurveyVote> listSurveyVotes ;
	@OneToMany(mappedBy="insured")
	private List<ActualityComment> listActualityComments ;
	@OneToMany(mappedBy="insured")
	private List<Reclamation> listReclamations ;
	@OneToMany(mappedBy="insured")
	private List<Contract> listContracts ;
	@OneToMany(mappedBy="insured")
	private List<Appointment> listAppointments ;

	public List<Appointment> getListAppointments() {
		return listAppointments;
	}

	public void setListAppointments(List<Appointment> listAppointments) {
		this.listAppointments = listAppointments;
	}

	public List<Contract> getListContracts() {
		return listContracts;
	}

	public void setListContracts(List<Contract> listContracts) {
		this.listContracts = listContracts;
	}

	public List<Reclamation> getListReclamations() {
		return listReclamations;
	}

	public void setListReclamations(List<Reclamation> listReclamations) {
		this.listReclamations = listReclamations;
	}

	public List<ActualityComment> getListActualityComments() {
		return listActualityComments;
	}

	public void setListActualityComments(List<ActualityComment> listActualityComments) {
		this.listActualityComments = listActualityComments;
	}

	public List<SurveyVote> getListSurveyVotes() {
		return listSurveyVotes;
	}

	public void setListSurveyVotes(List<SurveyVote> listSurveyVotes) {
		this.listSurveyVotes = listSurveyVotes;
	}

	public Insured() {
		super();
	}
   
}
