package services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Insured;
import domain.Survey;
import domain.SurveyVote;

/**
 * Session Bean implementation class ReunionService
 */
@Stateless
@LocalBean
public class SurveyVoteService implements SurveyVoteServiceRemote, SurveyVoteServiceLocal {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public SurveyVoteService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addSurveyVote(SurveyVote i) {
		em.merge(i);

	}

	@Override
	public void updateSurveyVote(SurveyVote i) {
		em.merge(i);

	}

	@Override
	public Survey findSurveyVote(int i) {
		return em.find(Survey.class, i);
	}

	@Override
	public void deleteSurveyVote(SurveyVote i) {
		em.remove(em.merge(i));

	}

	@Override
	public List<SurveyVote> findAllSurveyVote() {
		return em.createQuery("select s from SurveyVote s", SurveyVote.class).getResultList();
	}

	@Override
	public int SurveyVoteCount(String ch, int a) {

		List<SurveyVote> list = new ArrayList<>();
		list = em.createQuery("SELECT s FROM SurveyVote s where vote=:ch and survey_idSurvey=:a", SurveyVote.class)
				.setParameter("ch", ch).setParameter("a", a).getResultList();

		return list.size();
	}
	
	@Override
	public int SurveyVoteCountBySurvey(int a) {

		List<SurveyVote> list = new ArrayList<>();
		list = em.createQuery("SELECT s FROM SurveyVote s where survey_idSurvey=:a", SurveyVote.class).
				setParameter("a", a).getResultList();

		return list.size();
	}
	
	

	@Override
	public int SurveyVoteVerif(int insured, int survey) {

		List<SurveyVote> list = new ArrayList<>();
		list = em
				.createQuery("SELECT s FROM SurveyVote s where survey_idSurvey=:survey and insured_id=:insured",
						SurveyVote.class)
				.setParameter("insured", insured).setParameter("survey", survey).getResultList();

		return list.size();
	}
}
