package isurancejavaee.user;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import domain.User;
import services.UserServiceLocal;

@ManagedBean
@ViewScoped
public class stat {

	private PieChartModel pieModel1;
	private List<User> users;
	
	@EJB
	UserServiceLocal userLocal;
	
    @PostConstruct
    public void init() {
        
        users = new ArrayList<>();
        users = userLocal.findAllUsers();
        graph(users);
        
    }

    
    private void graph(List<User> users){
    	pieModel1 = new PieChartModel();
    	
    	
    	for (User user : users )
    	{ 
    		float n = user.getNbConnect();
    		pieModel1.set(user.getLogin(), n);
    	}
    	
    	pieModel1.setTitle("nombre de connection par user");
        pieModel1.setLegendPosition("w");
    	
    	
    	
    }


	public PieChartModel getPieModel1() {
		return pieModel1;
	}


	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}

}
