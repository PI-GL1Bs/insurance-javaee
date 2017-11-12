package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Car;
import domain.Reunion;

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

	@Override
	public Car GetLastCar() {
		return em.createQuery("select c from Car c ORDER By idCar", Car.class)
				.getResultList().get(0);
	
	}

	@Override
	public Car update(Car c) {
		em.persist(em.merge(c));
		em.flush();
		return c;
	}

}
