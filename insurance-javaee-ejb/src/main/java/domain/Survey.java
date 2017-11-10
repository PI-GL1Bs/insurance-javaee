package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Survey
 *
 */
@Entity
public class Survey implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idSurvey;
	private String description ; 
	private Date endDate ; 
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
   
	
	
	
	
}
