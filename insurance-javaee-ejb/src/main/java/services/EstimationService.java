package services;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Estimation;
@Stateless
@LocalBean
public class EstimationService implements EstimationServiceLocal{
	@PersistenceContext
	private EntityManager em ;
	@Override
	public void saveEstimation(Estimation i) {
		em.merge(i);	
	}


}
