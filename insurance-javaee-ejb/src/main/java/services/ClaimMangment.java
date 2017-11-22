package services;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import domain.*;
@Stateless
@LocalBean
public class ClaimMangment implements ClaimMangmentLocal{
	@PersistenceContext
	private EntityManager em ;
	@Override
	public boolean  addClaim(Claim i) {
	if (em.merge(i)!=null)
		return true;
	else 
		return false;
	}

	public ClaimMangment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean updateClaim(Claim i) {
		if (em.merge(i)!=null)
			return true;
		else 
			return false;
	}

	@Override
	public Claim findClaim(int i) {
		// TODO Auto-generated method stub
		return  em.find(Claim.class,i);
	}

	@Override
	public boolean deleteClaim(Claim i) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
		public List<Claim> findAllClaims() {
			return em.createQuery("select c from Claim c", Claim.class)
					.getResultList();
		}
	@Override
		public List<Claim> findClaimsByContact(Contract contract) {
			return em
					.createQuery("select p from Claim p where p.contract_refContract=:c",
							Claim.class).setParameter("c", contract)
					.getResultList();
		}
	@Override
		public List<Claim> findClaimsByStatus(int Status) {
		
			return  em.createQuery(
					"select c from Claim c where c.status=:x", Claim.class).setParameter("x", Status).getResultList();

	}

}
