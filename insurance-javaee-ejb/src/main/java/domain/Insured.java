<<<<<<< HEAD
package domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import domain.User;

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
	private Date dateOfContract;

	public Insured(int cin, String role, String name, String firstName, String photo, String mail, String adresse,
			String login, String password, String confrimPassword, String sex, int tel,
			List<SurveyVote> listSurveyVotes, List<ActualityComment> listActualityComments,
			List<Reclamation> listReclamations, List<Contract> listContracts, List<Appointment> listAppointments,
			Date dateOfContract) {
		super(cin, role, name, firstName, photo, mail, adresse, login, password, confrimPassword, sex, tel);
		this.listSurveyVotes = listSurveyVotes;
		this.listActualityComments = listActualityComments;
		this.listReclamations = listReclamations;
		this.listContracts = listContracts;
		this.listAppointments = listAppointments;
		this.dateOfContract = dateOfContract;
	}

	public Date getDateOfContract() {
		return dateOfContract;
	}

	public void setDateOfContract(Date dateOfContract) {
		this.dateOfContract = dateOfContract;
	}

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
=======
package domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import domain.User;

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
	private Date dateOfContract;

	public Insured(int cin, String role, String name, String firstName, String photo, String mail, String adresse,
			String login, String password, String confrimPassword, String sex, int tel,
			List<SurveyVote> listSurveyVotes, List<ActualityComment> listActualityComments,
			List<Reclamation> listReclamations, List<Contract> listContracts, List<Appointment> listAppointments,
			Date dateOfContract) {
		super(cin, role, name, firstName, photo, mail, adresse, login, password, confrimPassword, sex, tel);
		this.listSurveyVotes = listSurveyVotes;
		this.listActualityComments = listActualityComments;
		this.listReclamations = listReclamations;
		this.listContracts = listContracts;
		this.listAppointments = listAppointments;
		this.dateOfContract = dateOfContract;
	}

	public Date getDateOfContract() {
		return dateOfContract;
	}

	public void setDateOfContract(Date dateOfContract) {
		this.dateOfContract = dateOfContract;
	}

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
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
