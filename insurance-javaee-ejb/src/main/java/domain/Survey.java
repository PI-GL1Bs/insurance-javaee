package domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Entity implementation class for Entity: Survey
 *
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Survey implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idSurvey;
	private String description ; 
	private Date endDate ; 
	private String status ; 
	
	
	
    private static final long serialVersionUID = 1L;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="survey")
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
   
	
	
	
	
}
