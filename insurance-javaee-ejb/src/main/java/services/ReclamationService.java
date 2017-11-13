package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import domain.Insured;
import domain.Reclamation;

@Stateless
public class ReclamationService implements ReclamationServiceLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Reclamation reclamation) {
		em.persist(reclamation);
	}

	@Override
	public void save(Reclamation reclamation) {
		em.merge(reclamation);
	}

	@Override
	public void delete(Reclamation reclamation) {
		em.remove(em.merge(reclamation));
	}

	@Override
	public List<Reclamation> findAll() {
		return em.createQuery("select r from Reclamation r", Reclamation.class).getResultList();
	}

	@Override
	public List<Reclamation> findAllByInsured(Insured insured) {
		String jpql = "select r from Reclamation r where r.insured=:x";
		TypedQuery<Reclamation> query = em.createQuery(jpql, Reclamation.class);
		query.setParameter("x", insured);
		return null;
	}


}
