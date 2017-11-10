package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Car;

@Stateless
@LocalBean
public class CarService implements CarServiceLocal {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Car addCar(Car c) {
		em.persist(c);
		return c;
	}

}
