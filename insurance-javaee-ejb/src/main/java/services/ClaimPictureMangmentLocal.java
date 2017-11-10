package services;

import java.util.List;

import javax.ejb.Local;

import domain.ClaimPicture;
import domain.Contract;
@Local
public interface ClaimPictureMangmentLocal {
	public void addCliamPicture(ClaimPicture i) ;
	
	public ClaimPicture findCliamPicture(String i) ;
	public void deleteCliamPicture(ClaimPicture i) ;

	public List<ClaimPicture> findCliamPicturesByClaim(Contract contract);


}
