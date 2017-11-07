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
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Claim claim ;
	
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
