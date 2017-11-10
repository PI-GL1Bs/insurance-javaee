package services;

import java.util.List;

import javax.ejb.Local;

import domain.Contract;

@Local
public interface ContractServiceLocal {
	
	Contract create(Contract c );
	void update(Contract c );
	void delete(Contract c );
	List<Contract> findAllContracts();

}
