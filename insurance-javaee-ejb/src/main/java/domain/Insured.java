package domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import domain.User;

/**
 * Entity implementation class for Entity: Insured
 *
 */
@Entity

public class Insured extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonBackReference
	@OneToMany(mappedBy = "insured", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<SurveyVote> listSurveyVotes;

	@JsonBackReference
	@OneToMany(mappedBy = "insured", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ActualityComment> listActualityComments;

	@JsonBackReference
	@OneToMany(mappedBy = "insured", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Reclamation> listReclamations;

	@JsonBackReference
	@OneToMany(mappedBy = "insured", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Contract> listContracts;

	@JsonBackReference
	@OneToMany(mappedBy = "insured", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Appointment> listAppointments;

	private Date dateOfContract;

	public Insured(int cin, String role, String name, String firstName, String photo, String mail, String adresse,
			String login, String password, String confrimPassword, String sex, String PhoneNumber,
			List<SurveyVote> listSurveyVotes, List<ActualityComment> listActualityComments,
			List<Reclamation> listReclamations, List<Contract> listContracts, List<Appointment> listAppointments,
			Date dateOfContract) {

		this.listSurveyVotes = listSurveyVotes;
		this.listActualityComments = listActualityComments;
		this.listReclamations = listReclamations;
		this.listContracts = listContracts;
		this.listAppointments = listAppointments;
		this.dateOfContract = dateOfContract;
	}

	public Insured(int id, String role, String lastName, String firstName, String photo, String mail, String adresse,
			String login, String password, String confrimPassword, String sex, String phoneNumber,
			java.util.Date birthDate) {
		super(id, role, lastName, firstName, photo, mail, adresse, login, password, confrimPassword, sex, phoneNumber,
				birthDate);
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
