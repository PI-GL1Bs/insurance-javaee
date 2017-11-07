package services;

import java.util.List;

import javax.ejb.Local;

import domain.Reclamation;

@Local
public interface ReclamationServiceLocal {

	public Reclamation createReclamation(Reclamation reclamation);

	public void saveProduct(Reclamation reclamation);

	void removeProduct(Reclamation reclamation);

	List<Reclamation> findAllProducts();

	List<Reclamation> findReclamationByUser(Reclamation reclamation);

}
