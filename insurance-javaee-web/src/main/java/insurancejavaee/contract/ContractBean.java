package insurancejavaee.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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
import services.InsuredServiceLocal;

@ManagedBean
@ApplicationScoped
public class ContractBean {

	@EJB
	private ContractServiceLocal cm;
	@EJB
	private CarServiceLocal carser;
	@EJB
	private InsuredServiceLocal insurser;
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
		insured = new Insured();
		insured.setTel(555);
		insured.setDateOfContract(new Date());

		contract = new Contract();
		listContract = cm.findAllContracts();
	}

	public ContractBean() {
	}
	
	
	public String doSave() {
		contract.setCreationdate(new Date());
		carser.update(car);
		insurser.update(insured);
		cm.save(contract);
		listContract = cm.findAllContracts();
		return "listcontracts?faces-redirect=true";
	}
	
	public void doDelete() {
		cm.delete(contract);
		listContract = cm.findAllContracts();
	}
	
	public String doUpdate(int id) {
		contract = cm.findContractById(id);

		car= contract.getCar();
		insured = contract.getInsured();
		
		insured = contract.getInsured();
		return "updatecontract?faces-redirect=true";
		
	}

	public String addContract() {
		String navTo = "addcontract?faces-redirect=true";

		if (insurser.create(insured) != null ){
		if (carser.addCar(car) != null) {

			Contract c = new Contract();
			c.setCar(car);
			c.setInsured(insured);
			c.setPolice(5);
			if (cm.create(c) != null) {
				car.setContract(c);
				carser.update(car);
				listContract = cm.findAllContracts();
				navTo = "listcontracts?faces-redirect=true";

			}
		}}
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

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

}
