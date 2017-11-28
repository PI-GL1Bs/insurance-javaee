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
	public boolean create(Reclamation reclamation) {
		try {
			em.persist(reclamation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean save(Reclamation reclamation) {
		try {
			em.merge(reclamation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Reclamation reclamation) {
		try {
			em.remove(em.merge(reclamation));
			return true;
		} catch (Exception e) {
			return false;
		}
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

	@Override
	public Reclamation find(int id) {
		
		return em.find(Reclamation.class, id);
	}

}
