package services;

import java.util.List;

import javax.ejb.Local;

import domain.*;
@Local
public interface ClaimMangmentLocal {
	public void addClaim(Claim i) ;
	public void updateClaim(Claim i) ;
	public Claim findClaim(int i) ;
	public void deleteClaim(Claim i) ;
	public List<Claim> findAllClaims();
	public List<Claim> findClaimsByContact(Contract contract);
	public List<Claim> findClaimsByStatus(int Status);

}
