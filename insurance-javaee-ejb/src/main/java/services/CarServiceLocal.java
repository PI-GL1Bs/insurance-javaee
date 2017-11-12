package services;

import javax.ejb.Local;

import domain.Car;

@Local
public interface CarServiceLocal {

	Car addCar(Car c );
	Car GetLastCar();
	Car update(Car c);
}
