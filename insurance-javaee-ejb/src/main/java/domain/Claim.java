package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity
public class Claim implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idClaim;
	private String title;
	private Date date;
	private String place;
	private String description;
	private String status,damagePostion;
	private static final long serialVersionUID = 1L;
	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDamagePostion() {
		return damagePostion;
	}
	public void setDamagePostion(String damagePostion) {
		this.damagePostion = damagePostion;
	}
	public List<ClaimPicture> getListPicture() {
		return listPicture;
	}
	public void setListPicture(List<ClaimPicture> listPicture) {
		this.listPicture = listPicture;
	}
	@ManyToOne
	private Employee employee ;
	@OneToMany(mappedBy="claim")
	private List<Testimony> listTestimonies ;
	@OneToMany(mappedBy="claim")
	private List<ClaimPicture>listPicture ;
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
