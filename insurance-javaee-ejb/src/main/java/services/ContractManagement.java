package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Contract;

public class ContractManagement implements ContractManagementLocal{

	
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Contract c) {

		em.persist(c);
	}

	@Override
	public void update(Contract c) {
		em.merge(c);
		
	}

	@Override
	public void delete(Contract c) {
		em.remove(c);
		
	}

	@Override
	public List<Contract> findAllontracts() {
		// TODO Auto-generated method stub
		return null;
	}

}
