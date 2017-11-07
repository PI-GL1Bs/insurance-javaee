package services;

import java.util.List;

import javax.ejb.Stateless;

import domain.Reclamation;

@Stateless
public class ReclamationService implements ReclamationServiceLocal{

	@Override
	public Reclamation createReclamation(Reclamation reclamation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveProduct(Reclamation reclamation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(Reclamation reclamation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reclamation> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reclamation> findReclamationByUser(Reclamation reclamation) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
