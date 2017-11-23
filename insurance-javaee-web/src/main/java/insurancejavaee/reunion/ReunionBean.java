package insurancejavaee.reunion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import domain.Employee;
import domain.Reunion;
import isurancejavaee.user.AuthentificationBean;
import services.EmployeeServiceLocal;
import services.ReunionServiceLocal;
import utilities.MailSender;

@ManagedBean
@SessionScoped
public class ReunionBean {
	@EJB
	private ReunionServiceLocal reunionServiceLocal;
	@EJB
	private EmployeeServiceLocal employeeServiceLocal;
	@EJB
	MailSender mailSender = new MailSender();
	private Reunion reunion = new Reunion();
	private List<String> listMails;
	private List<Employee> listEmployee;
	private List<Reunion> listReunions;
	private String WeekDay;

	public ReunionBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		reunion = new Reunion();
		listReunions = reunionServiceLocal.findAllReunions();
		listEmployee = new ArrayList<Employee>();
	}

	public List<String> configureListMails() {
		listMails = new ArrayList<String>();
		String mailTo = reunion.getMailTo();
		int j = 0;
		for (int i = 0; i < mailTo.length(); i++) {
			if (mailTo.charAt(i) == ',' || mailTo.charAt(i) == ' ') {
				listMails.add(mailTo.substring(j, i));
				j = i + 1;
			}
		}
		return listMails;
	}

	public List<Employee> configureEmployeeByMail() {
		for (String mail : configureListMails()) {
			if (employeeServiceLocal.findEmployeeByMail(mail) != null) {
				Employee employee = (Employee) employeeServiceLocal.findEmployeeByMail(mail);
				listEmployee.add(employee);
			}

		}
		return listEmployee;
	}

	public String addReunion() {
		String navTo = "";
		listReunions = new ArrayList<Reunion>();

		listReunions.add(reunion);
		for (Employee employee : configureEmployeeByMail()) {
			employee.setListReunions(listReunions);
		}
		reunion.setListEmployees(listEmployee);
		
		if (reunionServiceLocal.addReunion(reunion) != null){
			mailSender.send("hamza.torjmen@esprit.tn", "test jboss", "wildfly hamza 9wiy");
			navTo = "meetings?faces-redirect=true";
		}
		listReunions = reunionServiceLocal.findAllReunions();
		return navTo;
	}

	public void prepareMeetingData(int id) {
		Reunion r1 = new Reunion();
		r1 = reunionServiceLocal.findReunionById(id);
		reunion.setIdReunion(r1.getIdReunion());
		reunion.setName(r1.getName());
		reunion.setDate(r1.getDate());
		reunion.setMailTo(r1.getMailTo());
		reunion.setDescription(r1.getDescription());
		reunion.setListEmployees(r1.getListEmployees());
	}

	public String goToUpdate() {
		String navTo = "";
		// int id ;
		// FacesContext fc = FacesContext.getCurrentInstance();
		// Map<String, String> params =
		// fc.getExternalContext().getRequestParameterMap();
		// id = Integer.parseInt(params.get("meetingId")) ;
		// prepareMeetingData(id);
		navTo = "updatereunion?faces-redirect=true";
		return navTo;
	}

	public String goToMeeting() {
		String navTo = "";
		int id;
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		id = Integer.parseInt(params.get("meetingId"));
		prepareMeetingData(id);
		navTo = "meeting?faces-redirect=true";
		return navTo;
	}

	public String updateMeeting() {
		String navTo = "";
		listReunions = new ArrayList<Reunion>();

		listReunions.add(reunion);

		for (Employee employee : configureEmployeeByMail()) {
			employee.setListReunions(listReunions);
		}
		reunion.setListEmployees(listEmployee);

		if (reunionServiceLocal.saveReunion(reunion) != null)
			navTo = "meetings?faces-redirect=true";
		listReunions = reunionServiceLocal.findAllReunions();
		return navTo;
	}

	public String deleteMeeting() {
		String navTo = "";
		if (reunionServiceLocal.removeMeeting(reunion))
			navTo = "meetings?faces-redirect=true";
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

	public String getWeekDay() {
		return WeekDay;
	}

	public void setWeekDay(String weekDay) {
		WeekDay = weekDay;
	}

	public List<Employee> getListEmployee() {
		return listEmployee;
	}

	public void setListEmployee(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}

}
