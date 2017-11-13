package services;

import javax.ejb.Local;

import domain.Estimation;
@Local
public interface EstimationServiceLocal {
	public void saveEstimation(Estimation i) ;
}
