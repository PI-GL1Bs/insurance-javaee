package domain;

import java.io.Serializable;
import javax.persistence.*;

import domain.User;

/**
 * Entity implementation class for Entity: Expert
 *
 */
@Entity
@Inheritance
public class Expert extends Employee implements Serializable {

	private String Diplome ;
	public String getDiplome() {
		return Diplome;
	}

	public void setDiplome(String diplome) {
		Diplome = diplome;
	}

	private static final long serialVersionUID = 1L;

	public Expert() {
		super();
	}
   
}
