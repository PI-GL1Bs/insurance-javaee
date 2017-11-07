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
	private int idSurveyVote;
	private static final long serialVersionUID = 1L;

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
   
}
