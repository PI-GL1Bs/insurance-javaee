package insurancejavaee.contract;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import domain.Car;
import domain.Contract;
import services.CarServiceLocal;

@ManagedBean
public class ContractBean {

	@EJB
	private CarServiceLocal cm;
	private Car car;
	private Contract contract;

	@PostConstruct
	public void init() {
		car = new Car();
		contract = new Contract();
	}
	
	
	
	
	public ContractBean() {
	}




	public String addContract() {
		String navTo ="failure" ;
		Car c = new Car();
		c.setMarque(car.getMarque());
		c.setMatricule(car.getMatricule());
		c.setModele(car.getModele());
		c.setContract(null);
		if (cm.addCar(c) != null)
			navTo="/reunion/addreunion?faces-redirect=true";
		return navTo ;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}
	
	
//	public Contract getContract() {
//		return contract;
//	}
//
//	public void setContract(Contract contract) {
//		this.contract = contract;
//	}

}
