
package domain;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

@Entity
@Inheritance
public class Agent extends Employee implements Serializable {

	private String statut ;
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}
   
}