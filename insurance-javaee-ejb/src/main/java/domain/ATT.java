<<<<<<< HEAD
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ATT
 *
 */
@Entity

public class ATT implements Serializable {

	   
	@Id
	private int idMatricule;
	private static final long serialVersionUID = 1L;

	public ATT() {
		super();
	}   
	public int getIdMatricule() {
		return this.idMatricule;
	}

	public void setIdMatricule(int idMatricule) {
		this.idMatricule = idMatricule;
	}
   
}
=======
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ATT
 *
 */
@Entity

public class ATT implements Serializable {

	   
	@Id
	private int idMatricule;
	private static final long serialVersionUID = 1L;

	public ATT() {
		super();
	}   
	public int getIdMatricule() {
		return this.idMatricule;
	}

	public void setIdMatricule(int idMatricule) {
		this.idMatricule = idMatricule;
	}
   
}
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
