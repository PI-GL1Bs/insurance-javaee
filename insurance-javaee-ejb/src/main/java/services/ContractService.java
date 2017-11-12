package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Car;
import domain.Contract;
import domain.Reunion;

@Stateless
@LocalBean
public class ContractService implements ContractServiceLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Contract create(Contract c) {

		em.persist(c);
		return c;
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
	public List<Contract> findAllContracts() {
		return em.createQuery("select r from Contract r", Contract.class).getResultList();

	}

	@Override
	public Contract getLast() {
		return em.createQuery("select c from Contract c  order by refContract", Contract.class)
				.getResultList().get(0);
	}

}
