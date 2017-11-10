package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Testimony
 *
 */
@Entity

public class Testimony implements Serializable {

	   
	@Id
	private int idTestimony;
	private String firstName,lastName,Email;
	private int phoneNumber;
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Claim claim ;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Testimony() {
		super();
	}   
	public int getIdTestimony() {
		return this.idTestimony;
	}

	public void setIdTestimony(int idTestimony) {
		this.idTestimony = idTestimony;
	}
	public Claim getClaim() {
		return claim;
	}
	public void setClaim(Claim claim) {
		this.claim = claim;
	}
   
}
