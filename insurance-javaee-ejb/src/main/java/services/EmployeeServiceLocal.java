package services;

import java.util.List;

import javax.ejb.Local;

import domain.Employee;
import domain.User;

@Local
public interface EmployeeServiceLocal {
	public List<Employee> findAllEmployee() ;
	public Employee findEmployeeByMail(String Mail);
}
