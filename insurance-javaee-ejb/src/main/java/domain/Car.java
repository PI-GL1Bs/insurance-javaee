package domain;

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
	private String marque;
	private String modele;
	private String matricule;
	
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
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	
	
   
}
