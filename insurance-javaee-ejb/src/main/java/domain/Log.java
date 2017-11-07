package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Log
 *
 */
@Entity

public class Log implements Serializable {

	   
	@Id
	private int idLog;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="log")
	private List<Contract> listContracts ;
	
	public Log() {
		super();
	}   
	public int getIdLog() {
		return this.idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}
	public List<Contract> getListContracts() {
		return listContracts;
	}
	public void setListContracts(List<Contract> listContracts) {
		this.listContracts = listContracts;
	}
   
}
