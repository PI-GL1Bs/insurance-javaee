package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import domain.User;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@XmlRootElement
public class Employee extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="employee",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Claim> listClaims;
	@ManyToMany(mappedBy="listInvitedEmployees",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonBackReference
	private List<Reunion> listReunions ;
	@OneToMany(mappedBy="employee",fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Appointment> listAppointments ;
public Date getDateOfHire() {
		return dateOfHire;
	}

	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	//	@ManyToOne
//	private Reunion reunion;
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

//	public Reunion getReunion() {
//		return reunion;
//	}
//
//	public void setReunion(Reunion reunion) {
//		this.reunion = reunion;
//	}
   
}
