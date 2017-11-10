package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Claim;
import domain.ClaimPicture;
import domain.Contract;
@Stateless
@LocalBean
public class ClaimPictureMangment implements ClaimPictureMangmentLocal{
	@PersistenceContext
	private EntityManager em ;
	@Override
	public void addCliamPicture(ClaimPicture i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClaimPicture findCliamPicture(String i) {
		return  em.find(ClaimPicture.class,i);
		
	}

	@Override
	public void deleteCliamPicture(ClaimPicture i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClaimPicture> findCliamPicturesByClaim(Contract contract) {
		// TODO Auto-generated method stub
		return null;
	}

}
