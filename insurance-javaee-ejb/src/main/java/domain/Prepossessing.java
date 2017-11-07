package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Prepossessing
 *
 */
@Entity

public class Prepossessing implements Serializable {

	   
	@Id
	private int idPrepossessing;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Contract contract ;
	
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public Prepossessing() {
		super();
	}   
	public int getIdPrepossessing() {
		return this.idPrepossessing;
	}

	public void setIdPrepossessing(int idPrepossessing) {
		this.idPrepossessing = idPrepossessing;
	}
   
}
