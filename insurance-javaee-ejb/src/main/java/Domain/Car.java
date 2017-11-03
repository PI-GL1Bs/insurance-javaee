package Domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Car
 *
 */
@Entity

public class Car implements Serializable {

	   
	@Id
	private int idCar;
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Contract contract ;
	
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public Car() {
		super();
	}   
	public int getIdCar() {
		return this.idCar;
	}

	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
   
}