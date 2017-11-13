package services;

import java.util.List;

import javax.ejb.Local;

import domain.Survey;

@Local
public interface SurveyServiceLocal {
	public void addSurvey(Survey i) ;
	public void updateSurvey(Survey i) ;
	public Survey findSurvey(int i) ;
	public void deleteSurvey(Survey i) ;
	public List<Survey> findAllSurvey();
	public List<Survey> findAllSurveyByDate();

}
