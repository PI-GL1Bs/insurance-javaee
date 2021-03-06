package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Employee;
import domain.Reunion;

/**
 * Session Bean implementation class ReunionService
 */
@Stateless
@LocalBean
public class ReunionService implements ReunionServiceRemote, ReunionServiceLocal {
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ReunionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Reunion addReunion(Reunion reunion) {
		em.persist(reunion);
		return reunion;
	}

	@Override
	public Reunion saveReunion(Reunion reunion) {
			em.merge(reunion);
			return reunion;
	}
	@Override
	public List<Reunion> findAllReunions() {
		String mail ="" ;
		List<Reunion> reunions = em.createQuery("select r from Reunion r", Reunion.class)
				.getResultList();
		for (Reunion reunion : reunions) {
			mail="";
			for (Employee employee : reunion.getListEmployees()) {
				mail = mail + employee.getMail() + " ";
			}
			reunion.setMailTo(mail);
		}
		return reunions;
	}

	@Override
	public Reunion findReunionById(int id) {
		return em.find(Reunion.class, id);
	}

	@Override
	public Boolean removeMeeting(Reunion reunion) {
		if (reunion != null) {
			em.remove(em.merge(reunion));
			return true ;
		}
		return false;
	}
}
