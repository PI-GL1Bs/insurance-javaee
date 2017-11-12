package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

/**
 * Entity implementation class for Entity: Reunion
 *
 */
@Entity

public class Reunion implements Serializable {

	   
	@Id
	@GeneratedValue
	private int idReunion;
	private String name ;
	private String description ;
	private Date date;
	@Transient
	private Calendar calendar ;
	@Transient
	private String mailTo;
	@ManyToMany
	private List<Employee> listInvitedEmployees ;
	private static final long serialVersionUID = 1L;
	
//	@ManyToOne
//	private Employee employee ;
//	
//	public Employee getEmployee() {
//		return employee;
//	}
//	public void setEmployee(Employee employee) {
//		this.employee = employee;
//	}
	public Reunion() {
		super();
	}   
	public int getIdReunion() {
		return this.idReunion;
	}

	public void setIdReunion(int idReunion) {
		this.idReunion = idReunion;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Employee> getListEmployees() {
		return listInvitedEmployees;
	}
	public void setListEmployees(List<Employee> listEmployees) {
		this.listInvitedEmployees = listEmployees;
	}
	public String getMailTo() {
		return mailTo;
	}
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	@Override
	public String toString() {
		return "Reunion [idReunion=" + idReunion + ", name=" + name + ", description=" + description + ", date=" + date
				+ "]";
	}
	public Calendar getCalendar() {
		return calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
   
}
