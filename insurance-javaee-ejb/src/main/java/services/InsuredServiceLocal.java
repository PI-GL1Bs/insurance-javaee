package services;

import java.util.List;

import javax.ejb.Local;

import domain.Insured;

@Local
public interface InsuredServiceLocal {
	Insured create(Insured i);
	
	void update(Insured i );
	void delete(Insured i );
	List<Insured> findAllInsureds();
}
