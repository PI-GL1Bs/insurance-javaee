package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Survey;

/**
 * Session Bean implementation class ReunionService
 */
@Stateless
@LocalBean
public class SurveyService implements SurveyServiceRemote, SurveyServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public SurveyService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Survey addSurvey(Survey i) {
		em.merge(i);
		return i ; 
	}

	@Override
	public List<Survey> findAllSurvey() {
		 List<Survey> surveys = em.createQuery("select s from Survey s", Survey.class).getResultList();
		 return surveys ; 
	}

	@Override
	public Survey updateSurvey(Survey i) {
		em.merge(i);
		return i  ;
	}

	@Override
	public Survey findSurvey(int i) {
		return em.find(Survey.class, i);
	}

	@Override
	public void deleteSurvey(Survey i) {
		em.remove(em.merge(i));

	}

	@Override
	public List<Survey> findAllSurveyByDate() {
		return em.createQuery("select s from Survey s  where endDate >= cast((now()) as date)", Survey.class)
				.getResultList();
	}
	
	
}
