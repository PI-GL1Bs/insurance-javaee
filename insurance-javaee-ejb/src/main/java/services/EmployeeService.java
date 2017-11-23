package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Employee;
import domain.User;

/**
 * Session Bean implementation class EmployeeService
 */
@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceRemote, EmployeeServiceLocal {
	@PersistenceContext
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public EmployeeService() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<Employee> findAllEmployee() {
		return em.createQuery("select e from User e where e.USER_TYPE='Employee'", Employee.class)
				.getResultList();
	}
	@Override
	public Employee findEmployeeByMail(String Mail) {
		return em.createQuery("select e from Employee e where e.mail=:x", Employee.class)
				.setParameter("x", Mail).getSingleResult();
	}

}
