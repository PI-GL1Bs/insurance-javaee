package insurancejavaee.reunion;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import domain.Employee;
import domain.Reunion;
import services.ReunionServiceLocal;

@ManagedBean
@SessionScoped
public class ReunionBean {
	@EJB
	private ReunionServiceLocal reunionServiceLocal;
	private Reunion reunion = new Reunion();
	private List<String> listMails;
	private List<Employee> listEmployee;
	private List<Reunion> listReunions;

	public ReunionBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		reunion = new Reunion();
		listReunions = reunionServiceLocal.findAllReunions();
	}

	public List<String> configureList() {
		String mailTo = reunion.getMailTo();
		int j = 0;
		for (int i = 0; i < mailTo.length(); i++) {
			if (mailTo.charAt(i) == ',') {
				listMails.add(mailTo.substring(j, i - 1));
				j = i + 1;
			}
		}
		return listMails;
	}

	public List<Employee> configureEmployeeByMail() {

		return listEmployee;
	}

	public String addReunion() {
		String navTo = "";
		Reunion r1 = new Reunion();
		r1.setName(reunion.getName());
		r1.setDescription(reunion.getDescription());
		r1.setDate(reunion.getDate());
		if (reunionServiceLocal.addReunion(r1) != null)
			navTo = "meetings?faces-redirect=true";
		listReunions = reunionServiceLocal.findAllReunions();
		return navTo;
	}
	public void prepareMeetingData (int id) {
		Reunion r1 = new Reunion();
		r1 = reunionServiceLocal.findReunionById(id);	
		reunion.setIdReunion(r1.getIdReunion());
		reunion.setName(r1.getName());
		reunion.setDate(r1.getDate());
		reunion.setDescription(r1.getDescription());
	}
	public String goToUpdate() {
		String navTo = "";
//		int id ;
//		FacesContext fc = FacesContext.getCurrentInstance();
//		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
//		id = Integer.parseInt(params.get("meetingId")) ;
//		prepareMeetingData(id);
		navTo = "updatereunion?faces-redirect=true";
		return navTo;
	}
	public String goToMeeting () {
		String navTo = "";
		int id ;
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		id = Integer.parseInt(params.get("meetingId")) ;
		prepareMeetingData(id);
		navTo = "meeting?faces-redirect=true";
		return navTo;
	}
	public String updateMeeting () {
		String navTo ="" ;
		Reunion r1 = new Reunion();
		r1.setIdReunion(reunion.getIdReunion());
		r1.setName(reunion.getName());
		r1.setDescription(reunion.getDescription());
		r1.setDate(reunion.getDate());
		System.out.println(r1);
		System.out.println("teeest");
		if (reunionServiceLocal.saveReunion(r1) != null)
			navTo = "meetings?faces-redirect=true";
		listReunions = reunionServiceLocal.findAllReunions();
		return navTo ;
	}
	public String deleteMeeting () {
		String navTo ="" ;
		if (reunionServiceLocal.removeMeeting(reunion))
			navTo="meetings?faces-redirect=true" ;
		listReunions = reunionServiceLocal.findAllReunions();
		return navTo;
	}
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

	public List<String> getListMails() {
		return listMails;
	}

	public void setListMails(List<String> listMails) {
		this.listMails = listMails;
	}

	public List<Reunion> getListReunions() {
		return listReunions;
	}

	public void setListReunions(List<Reunion> listReunions) {
		this.listReunions = listReunions;
	}

}
