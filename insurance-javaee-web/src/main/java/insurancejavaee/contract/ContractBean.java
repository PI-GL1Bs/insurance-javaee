package insurancejavaee.contract;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.Car;
import domain.Contract;
import domain.Reunion;
import services.CarServiceLocal;
import services.ContractServiceLocal;

@ManagedBean
@ApplicationScoped
public class ContractBean {

	@EJB
	private ContractServiceLocal cm;
	@EJB
	private CarServiceLocal carser;
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
		String navTo = "";

		if (carser.addCar(car) != null) {

			Contract c = new Contract();
			c.setCar(car);

			if (cm.create(c) != null) {
				car.setContract(c);
				carser.update(car);

				navTo = "contracts?faces-redirect=true";

			}
		}
		;

		return navTo;

	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	// public Contract getContract() {
	// return contract;
	// }
	//
	// public void setContract(Contract contract) {
	// this.contract = contract;
	// }

}
