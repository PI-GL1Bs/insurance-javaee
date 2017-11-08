package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import domain.User;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@DiscriminatorValue("employee")
public class Employee extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="employee")
	private List<Claim> listClaims;
	@OneToMany(mappedBy="employee")
	private List<Reunion> listReunions ;
	@OneToMany(mappedBy="employee")
	private List<Appointment> listAppointments ;
//	@ManyToOne
//	private Reunion reunion;
	
	public List<Appointment> getListAppointments() {
		return listAppointments;
	}

	public void setListAppointments(List<Appointment> listAppointments) {
		this.listAppointments = listAppointments;
	}

	public Employee() {
		super();
	}

	public List<Claim> getListClaims() {
		return listClaims;
	}

	public void setListClaims(List<Claim> listClaims) {
		this.listClaims = listClaims;
	}
	
	public List<Reunion> getListReunions() {
		return listReunions;
	}

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
