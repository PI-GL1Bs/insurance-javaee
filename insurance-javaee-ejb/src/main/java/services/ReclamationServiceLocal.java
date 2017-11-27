package services;

import java.util.List;

import javax.ejb.Local;

import domain.Insured;
import domain.Reclamation;

@Local
public interface ReclamationServiceLocal {

	boolean create(Reclamation reclamation );
	boolean save(Reclamation reclamation );
	boolean delete(Reclamation reclamation );

	Reclamation find(int id);
	List<Reclamation> findAll();
	List<Reclamation> findAllByInsured(Insured insured);

}
