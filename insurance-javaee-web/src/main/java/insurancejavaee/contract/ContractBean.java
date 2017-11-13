package insurancejavaee.contract;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import domain.Car;
import domain.Contract;
import domain.Insured;
import domain.Police;
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
	private Insured insured;
	private Contract contract;
	private List<Contract> listContract = new ArrayList<Contract>() ;


	public List<Contract> getListContract() {
		return listContract;
	}

	public void setListContract(List<Contract> listContract) {
		this.listContract = listContract;
	}

	@PostConstruct
	public void init() {
		car = new Car();
		contract = new Contract();
		insured = new Insured();
		listContract = cm.findAllContracts();
	}

	public ContractBean() {
	}

	public String addContract() {
		String navTo = "addcontract?faces-redirect=true";
		
		if (carser.addCar(car) != null) {

			Contract c = new Contract();
			c.setCar(car);
			c.setPolice(5);
			if (cm.create(c) != null) {
				car.setContract(c);
				carser.update(car);

				navTo = "listcontracts?faces-redirect=true";

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

	 public Contract getContract() {
	 return contract;
	 }
	
	 public void setContract(Contract contract) {
	 this.contract = contract;
	 }

}
