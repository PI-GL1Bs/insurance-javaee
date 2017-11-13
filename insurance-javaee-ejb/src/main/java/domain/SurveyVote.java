package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: SurveyVote
 *
 */
@Entity

public class SurveyVote implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idSurveyVote;
	private static final long serialVersionUID = 1L;
    private String vote ; 
	
	@ManyToOne
	private Insured insured ;
	@ManyToOne
	private Survey survey;
	
	public Insured getInsured() {
		return insured;
	}
	public void setInsured(Insured insured) {
		this.insured = insured;
	}
	public SurveyVote() {
		super();
	}   
	public int getIdSurvey() {
		return this.idSurveyVote;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurveyVote = idSurvey;
	}
	public int getIdSurveyVote() {
		return idSurveyVote;
	}
	public void setIdSurveyVote(int idSurveyVote) {
		this.idSurveyVote = idSurveyVote;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
	
	
}
