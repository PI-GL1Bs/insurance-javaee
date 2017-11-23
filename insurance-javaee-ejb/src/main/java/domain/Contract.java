package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contract
 *
 */
@Entity

public class Contract implements Serializable {

	@Id
	@GeneratedValue

	private int refContract;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Insured insured;
	@OneToMany
	private List<Claim> listClaims;
	@OneToMany
	private List<Prepossessing> listPrepossessings;
	@OneToOne
	private Car car;
	@ManyToOne
	private Log log;
	private int police;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationdate;

	
	@PrePersist
	public void meth(){
		creationdate = new Date();
	}
	
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

	public int getPolice() {
		return police;
	}

	public void setPolice(int police) {
		this.police = police;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

}
