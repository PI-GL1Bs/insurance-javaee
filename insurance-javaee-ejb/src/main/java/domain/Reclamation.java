<<<<<<< HEAD
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity

public class Reclamation implements Serializable {

	   
	@Id
	private int idReclamation;
	private static final long serialVersionUID = 1L;
	
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	@ManyToOne
	private Insured insured ;
	
	public Reclamation() {
		super();
	}   
	public int getIdReclamation() {
		return this.idReclamation;
	}

	public void setIdReclamation(int idReclamation) {
		this.idReclamation = idReclamation;
	}
   
}
=======
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity

public class Reclamation implements Serializable {

	   
	@Id
	private int idReclamation;
	private static final long serialVersionUID = 1L;
	
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	@ManyToOne
	private Insured insured ;
	
	public Reclamation() {
		super();
	}   
	public int getIdReclamation() {
		return this.idReclamation;
	}

	public void setIdReclamation(int idReclamation) {
		this.idReclamation = idReclamation;
	}
   
}
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
