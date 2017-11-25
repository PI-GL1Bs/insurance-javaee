package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee extends User implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private List<Claim> listClaims;
	@ManyToMany(mappedBy = "listInvitedEmployees", fetch = FetchType.EAGER)
	@JsonBackReference
	private List<Reunion> listReunions;
	@OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
	private List<Appointment> listAppointments;

	public Date getDateOfHire() {
		return dateOfHire;
	}

	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	// @ManyToOne
	// private Reunion reunion;
	private Date dateOfHire;

	public List<Appointment> getListAppointments() {
		return listAppointments;
	}

	@XmlAttribute
	public void setListAppointments(List<Appointment> listAppointments) {
		this.listAppointments = listAppointments;
	}

	public Employee() {
		super();
	}

	public List<Claim> getListClaims() {
		return listClaims;
	}

	@XmlAttribute
	public void setListClaims(List<Claim> listClaims) {
		this.listClaims = listClaims;
	}

	public List<Reunion> getListReunions() {
		return listReunions;
	}

	@XmlAttribute
	public void setListReunions(List<Reunion> listReunions) {
		this.listReunions = listReunions;
	}

	@Override
	public String toString() {
		return "Employee [listClaims=" + listClaims + ", listAppointments=" + listAppointments + ", dateOfHire="
				+ dateOfHire + ", getPhoneNumber()=" + getPhoneNumber() + ", getBirthDate()=" + getBirthDate()
				+ ", getRole()=" + getRole() + ", getId()=" + getId() + ", getLastName()=" + getLastName()
				+ ", getFirstName()=" + getFirstName() + ", getPhoto()=" + getPhoto() + ", getMail()=" + getMail()
				+ ", getAdresse()=" + getAdresse() + ", getLogin()=" + getLogin() + ", getPassword()=" + getPassword()
				+ ", getConfrimPassword()=" + getConfrimPassword() + ", getSex()=" + getSex() + ", getNbConnect()="
				+ getNbConnect() + "]";
	}

}
