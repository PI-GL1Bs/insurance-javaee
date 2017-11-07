<<<<<<< HEAD
package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Survey
 *
 */
@Entity

public class Survey implements Serializable {

	   
	@Id
	private int idSurvey;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="survey")
	private List<SurveyVote> listSurveyVotes ;

	public Survey() {
		super();
	}   
	public int getIdSurvey() {
		return this.idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}
	public List<SurveyVote> getListSurveyVotes() {
		return listSurveyVotes;
	}
	public void setListSurveyVotes(List<SurveyVote> listSurveyVotes) {
		this.listSurveyVotes = listSurveyVotes;
	}
   
}
=======
package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Survey
 *
 */
@Entity

public class Survey implements Serializable {

	   
	@Id
	private int idSurvey;
	private static final long serialVersionUID = 1L;
	@OneToMany(mappedBy="survey")
	private List<SurveyVote> listSurveyVotes ;

	public Survey() {
		super();
	}   
	public int getIdSurvey() {
		return this.idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}
	public List<SurveyVote> getListSurveyVotes() {
		return listSurveyVotes;
	}
	public void setListSurveyVotes(List<SurveyVote> listSurveyVotes) {
		this.listSurveyVotes = listSurveyVotes;
	}
   
}
>>>>>>> branch 'master' of https://github.com/PI-GL1Bs/insurance-javaee
