package services;

import java.util.List;

import javax.ejb.Local;

import domain.*;
@Local
public interface ClaimMangmentLocal {
	public boolean addClaim(Claim i) ;
	public boolean updateClaim(Claim i) ;
	public Claim findClaim(int i) ;
	public boolean deleteClaim(Claim i) ;
	public List<Claim> findAllClaims();
	public List<Claim> findClaimsByContact(Contract contract);
	public List<Claim> findClaimsByStatus(int Status);

}
