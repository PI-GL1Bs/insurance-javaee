package domain;

import java.io.Serializable;
import java.sql.Date;
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
    private Date dateOfHire ;


	public Date getDateOfHire() {
		return dateOfHire;
	}

	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

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
   
}
