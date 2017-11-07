<<<<<<< HEAD
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Police
 *
 */
@Entity

public class Police implements Serializable {

	   
	@Id
	private int idPolice;
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Contract contract ;
	
	public Police() {
		super();
	}   
	public int getIdPolice() {
		return this.idPolice;
	}

	public void setIdPolice(int idPolice) {
		this.idPolice = idPolice;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
   
}
=======
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Police
 *
 */
@Entity

public class Police implements Serializable {

	   
	@Id
	private int idPolice;
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Contract contract ;
	
	public Police() {
		super();
	}   
	public int getIdPolice() {
		return this.idPolice;
	}

	public void setIdPolice(int idPolice) {
		this.idPolice = idPolice;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
   
}
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
