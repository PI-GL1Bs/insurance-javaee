package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import domain.Testimony;
@Stateless
@LocalBean
public class TestimonyManagmentService implements TestimonyMangmentLocal{
	@PersistenceContext
	private EntityManager em ;
	@Override
	public void saveTestimony(Testimony i) {
		em.merge(i);	
	}
	@Override
	public void deleteTestimony(Testimony i) {
		em.remove(em.merge(i));
		
	}

}
