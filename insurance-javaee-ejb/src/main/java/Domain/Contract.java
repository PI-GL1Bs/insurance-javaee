package Domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity

public class Contract implements Serializable {

	   
	@Id
	private int refContract;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Insured insured ;
	@OneToMany(mappedBy="contract")
	private List<Claim> listClaims ;
	@OneToMany(mappedBy="contract")
	private List<Prepossessing> listPrepossessings ;
	@OneToOne(mappedBy="contract")
	private Car car ;
	@ManyToOne
	private Log log ;
	@OneToOne(mappedBy="contract")
	private Police police ;
	
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public Contract() {
		super();
	}   
	public int getRefContract() {
		return this.refContract;
	}

	public void setRefContract(int refContract) {
		this.refContract = refContract;
	}
	public List<Claim> getListClaims() {
		return listClaims;
	}
	public void setListClaims(List<Claim> listClaims) {
		this.listClaims = listClaims;
	}
	public List<Prepossessing> getListPrepossessings() {
		return listPrepossessings;
	}
	public void setListPrepossessings(List<Prepossessing> listPrepossessings) {
		this.listPrepossessings = listPrepossessings;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Police getPolice() {
		return police;
	}
	public void setPolice(Police police) {
		this.police = police;
	}
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}
   
}
