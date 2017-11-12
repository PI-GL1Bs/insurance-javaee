package services;

import java.util.List;

import javax.ejb.Local;

import domain.Insured;
import domain.Reclamation;

@Local
public interface ReclamationServiceLocal {

	void create(Reclamation reclamation );
	void update(Reclamation reclamation );
	void delete(Reclamation reclamation );

	List<Reclamation> findAll();
	List<Reclamation> findAllByInsured(Insured insured);

}
