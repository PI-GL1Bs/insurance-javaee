package services;

import java.util.List;

import javax.ejb.Local;

import domain.Insured;
import domain.Survey;
import domain.SurveyVote;

@Local
public interface SurveyVoteServiceLocal {
	public void addSurveyVote(SurveyVote i) ;
	public void updateSurveyVote(SurveyVote i) ;
	public Survey findSurveyVote(int i) ;
	public void deleteSurveyVote(SurveyVote i) ;
	public List<SurveyVote> findAllSurveyVote();

	public int SurveyVoteCount (String ch , int a) ; 
	
	public int SurveyVoteVerif (int insured , int survey) ; 
	
}
