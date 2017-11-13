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
	
	private int nbCar;
	private String title;
	private Date date;
	private String place;
	private String description;
	private boolean Injury, damageToOtherProperty;
	private String status,damagePostion;
	private byte[] picture;
	private static final long serialVersionUID = 1L;
	/*private String[] Circumstances;

	public String[] getCircumstances() {
		return Circumstances;
	}
	public void setCircumstances(String[] circumstances) {
		Circumstances = circumstances;
	}*/
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
	@OneToOne(mappedBy="claim",cascade = CascadeType.ALL)
	private Estimation estimation ;
	public Claim() {
		super();
	} 
	
	public Estimation getEstimation() {
		return estimation;
	}
	public void setEstimation(Estimation estimation) {
		this.estimation = estimation;
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
	public int getNbCar() {
		return nbCar;
	}
	public void setNbCar(int nbCar) {
		this.nbCar = nbCar;
	}
	public boolean isInjury() {
		return Injury;
	}
	public void setInjury(boolean injury) {
		Injury = injury;
	}
	public boolean isDamageToOtherProperty() {
		return damageToOtherProperty;
	}
	public void setDamageToOtherProperty(boolean damageToOtherProperty) {
		this.damageToOtherProperty = damageToOtherProperty;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
   
}
