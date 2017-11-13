package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Contract;
import domain.Insured;

@Stateless
@LocalBean
public class InsuredService implements InsuredServiceLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Insured create(Insured i) {
		em.persist(i);
		return i;
	}

	@Override
	public void update(Insured i) {
		em.merge(i);
		
	}

	@Override
	public void delete(Insured i) {
		em.remove(i);

	}

	@Override
	public List<Insured> findAllInsureds() {
		return em.createQuery("select i from Insured i", Insured.class).getResultList();
	}

}
