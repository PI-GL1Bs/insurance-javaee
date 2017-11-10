package insurancejavaee.survey;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import domain.*;
import services.*;

@ManagedBean
@ViewScoped
public class SurveyBean {
	@EJB
	private  SurveyServiceLocal surveyServiceLocal ;
	private  Survey  survey = new Survey() ; 
	private List<Survey> listSurvey = new ArrayList<Survey>() ;
	private  boolean formDisplayed;
	
	
	@PostConstruct
	public void init() {
		listSurvey = surveyServiceLocal.findAllSurvey();
	}
	
	
	
	
	public SurveyBean() {
	
	}




	public SurveyServiceLocal getSurveyServiceLocal() {
		return surveyServiceLocal;
	}
	public void setSurveyServiceLocal(SurveyServiceLocal surveyServiceLocal) {
		this.surveyServiceLocal = surveyServiceLocal;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public List<Survey> getListSurvey() {
		return listSurvey;
	}
	public void setListSurvey(List<Survey> listSurvey) {
		this.listSurvey = listSurvey;
	}
	public boolean isFormDisplayed() {
		return formDisplayed;
	}
	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	


	
}


