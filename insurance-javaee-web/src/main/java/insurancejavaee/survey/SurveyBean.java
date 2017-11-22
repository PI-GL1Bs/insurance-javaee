package insurancejavaee.survey;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.*;
import services.*;

@ManagedBean
@SessionScoped
public class SurveyBean {
	@EJB
	private SurveyServiceLocal surveyServiceLocal;
	@EJB
	private SurveyVoteServiceLocal surveyVoteServiceLocal;

//	@ManagedProperty(value="#{AuthBean.user}")
//	private User user;

    Insured insured = new Insured() ;
    
	
	public int oui;
	public int non;
	public int tot;

	public float POui;
	public float PNon;

	private SurveyVote surveyVote = new SurveyVote();
	private List<SurveyVote> listSurveyVote = new ArrayList<SurveyVote>();

	private Survey survey = new Survey();
	private List<Survey> listSurvey = new ArrayList<Survey>();

	private List<Survey> listSurveyFront = new ArrayList<Survey>();

	private boolean formDisplayed;

	@PostConstruct
	public void init() {

		listSurvey = surveyServiceLocal.findAllSurvey();

		listSurveyFront = surveyServiceLocal.findAllSurveyByDate();

		listSurveyVote = surveyVoteServiceLocal.findAllSurveyVote();
	}

	public SurveyBean() {

	}

	public String voter(int i) {

		SurveyVote sv = new SurveyVote();
		init();
		if ((surveyVote.getVote()).equals("oui")) {
			sv.setVote("oui");
		} else if ((surveyVote.getVote()).equals("non")) {
			sv.setVote("non");
		}

		insured.setId(123456);
	
		sv.setInsured(insured);
		sv.setSurvey(survey);

		int a=surveyVoteServiceLocal.SurveyVoteVerif(insured.getId(), survey.getIdSurvey()) ;
		if (a!=0)
		{
			return "/surveyFront/voted?faces-redirect=true";
		}
		surveyVoteServiceLocal.addSurveyVote(sv);
        return "/surveyFront/listsurvey?faces-redirect=true";
		

	}

	public String addSurvey() {
		String navTo = "/survey/listsurvey?faces-redirect=true";
		Survey r1 = new Survey();
		if (survey.getIdSurvey() != 0) {
			r1.setIdSurvey(survey.getIdSurvey());
		}
		r1.setDescription(survey.getDescription());
		r1.setEndDate(survey.getEndDate());
		surveyServiceLocal.addSurvey(r1);
		init();
		return navTo;
	}

	public String navCreate() {
		this.survey = new Survey();
		return "/survey/addsurvey?faces-redirect=true";

	}

	public String doDelete() {
		surveyServiceLocal.deleteSurvey(survey);
		init();
		return "/survey/listsurvey?faces-redirect=true";
	}

	public String navDetailsSurvaysFront() {

		return "/surveyFront/detailsSurvey?faces-redirect=true";
	}

	public String navSurveysFront() {

		return "/surveyFront/listsurvey?faces-redirect=true";
	}
	
	public String navSurveysList() {

		return "/survey/listsurvey?faces-redirect=true";
	}
	
	
	public String navToSurvey() {

		oui = surveyVoteServiceLocal.SurveyVoteCount("oui", survey.getIdSurvey());
		non = surveyVoteServiceLocal.SurveyVoteCount("non", survey.getIdSurvey());

		tot = oui + non;

		if (tot != 0) {
			POui = oui * 100 / tot;
			PNon = non * 100 / tot;
		}

		return "/survey/detailsSurvey?faces-redirect=true&oui=" + oui + "&non=" + non;
	}

	public String navUpdate() {
		init();
		return "/survey/addsurvey?faces-redirect=true";

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

	public SurveyVoteServiceLocal getSurveyVoteServiceLocal() {
		return surveyVoteServiceLocal;
	}

	public void setSurveyVoteServiceLocal(SurveyVoteServiceLocal surveyVoteServiceLocal) {
		this.surveyVoteServiceLocal = surveyVoteServiceLocal;
	}

	public SurveyVote getSurveyVote() {
		return surveyVote;
	}

	public void setSurveyVote(SurveyVote surveyVote) {
		this.surveyVote = surveyVote;
	}

	public List<SurveyVote> getListSurveyVote() {
		return listSurveyVote;
	}

	public void setListSurveyVote(List<SurveyVote> listSurveyVote) {
		this.listSurveyVote = listSurveyVote;
	}

	public int getOui() {
		return oui;
	}

	public void setOui(int oui) {
		this.oui = oui;
	}

	public int getNon() {
		return non;
	}

	public void setNon(int non) {
		this.non = non;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public float getPOui() {
		return POui;
	}

	public void setPOui(float pOui) {
		POui = pOui;
	}

	public float getPNon() {
		return PNon;
	}

	public void setPNon(float pNon) {
		PNon = pNon;
	}

	public List<Survey> getListSurveyFront() {
		return listSurveyFront;
	}

	public void setListSurveyFront(List<Survey> listSurveyFront) {
		this.listSurveyFront = listSurveyFront;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

}
