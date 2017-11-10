package services;

import java.util.List;

import javax.ejb.Local;

import domain.Survey;

@Local
public interface SurveyServiceLocal {
	public void addSurvey(Survey i) ;
	public void updateClaim(Survey i) ;
	public Survey findClaim(int i) ;
	public void deleteClaim(Survey i) ;
	public List<Survey> findAllSurvey();

}
