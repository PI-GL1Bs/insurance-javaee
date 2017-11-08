package insurancejavaee.reunion;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import domain.Reunion;
import services.ReunionServiceLocal;

@ManagedBean
public class ReunionBean {
	@EJB
	private ReunionServiceLocal reunionServiceLocal ;
	private Reunion reunion = new Reunion();
	public ReunionBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String addReunion() {
		String navTo ="" ;
		Reunion r1 = new Reunion();
		r1.setName(reunion.getName());
		r1.setDescription(reunion.getDescription());
		r1.setDate(reunion.getDate());
		if (reunionServiceLocal.addReunion(r1) != null)
			navTo="";
		return navTo ;
	}
	
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}

}
