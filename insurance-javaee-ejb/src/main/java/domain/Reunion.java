package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Entity implementation class for Entity: Reunion
 *
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Reunion implements Serializable {

	   
	@Id
	@GeneratedValue
	private int idReunion;
	private String name ;
	private String description ;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date date;
	@Transient
	private String mailTo;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Employee> listInvitedEmployees ;
	private static final long serialVersionUID = 1L;
	
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
	public List<Employee> getListInvitedEmployees() {
		return listInvitedEmployees;
	}
	public void setListInvitedEmployees(List<Employee> listInvitedEmployees) {
		this.listInvitedEmployees = listInvitedEmployees;
	}
	@Override
	public String toString() {
		return "Reunion [idReunion=" + idReunion + ", name=" + name + ", description=" + description + ", date=" + date
				+ ", mailTo=" + mailTo + ", listInvitedEmployees=" + listInvitedEmployees + "]";
	}
	
   
}
