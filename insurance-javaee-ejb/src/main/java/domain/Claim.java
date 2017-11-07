package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity

public class Claim implements Serializable {

	   
	@Id
	private int idClaim;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Employee employee ;
	@OneToMany(mappedBy="claim")
	private List<Testimony> listTestimonies ;
	@ManyToOne
	private Contract contract ;
	
	public Claim() {
		super();
	}   
	public int getIdClaim() {
		return this.idClaim;
	}

	public void setIdClaim(int idClaim) {
		this.idClaim = idClaim;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public List<Testimony> getListTestimonies() {
		return listTestimonies;
	}
	public void setListTestimonies(List<Testimony> listTestimonies) {
		this.listTestimonies = listTestimonies;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
   
}
