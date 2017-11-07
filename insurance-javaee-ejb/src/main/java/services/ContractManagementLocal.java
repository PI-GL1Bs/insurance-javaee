package services;

import java.util.List;

import javax.ejb.Local;

import domain.Contract;

@Local
public interface ContractManagementLocal {
	
	void create(Contract c );
	void update(Contract c );
	void delete(Contract c );
	List<Contract> findAllontracts();

}
