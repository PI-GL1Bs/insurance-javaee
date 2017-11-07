package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reunion
 *
 */
@Entity

public class Reunion implements Serializable {

	   
	@Id
	private int idReunion;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Employee employee ;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Reunion() {
		super();
	}   
	public int getIdReunion() {
		return this.idReunion;
	}

	public void setIdReunion(int idReunion) {
		this.idReunion = idReunion;
	}
   
}
