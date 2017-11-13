package services;



import javax.ejb.Local;

import domain.Testimony;

@Local
public interface TestimonyMangmentLocal {
	public void saveTestimony(Testimony i) ;
	public void deleteTestimony(Testimony i) ;

}
