package services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import domain.Insured;

/**
 * Session Bean implementation class InsuredService
 */
@Stateless
@LocalBean
public class InsuredService implements InsuredServiceLocal {

	@PersistenceContext
	private EntityManager em;

    public InsuredService() {
     
    }
  
    	public void saveOrUpdate(Insured insured) {
    		em.merge(insured);
    	}
    	public Insured findInsuredById(int id) {
    		return em.find(Insured.class, id);
    	}

    	public void removeInsured(Insured insured) {
    		insured=em.find(Insured.class,insured.getId());
    		em.remove(insured);
    	}

    	public List<Insured> findAllInsured() {
    		return em.createQuery("select c from Insured c", Insured.class)
    				.getResultList();
    	}

    	public Insured findInsuredByName(String name) {
    		Insured found = null;
    		TypedQuery<Insured> query = em.createQuery(
    				"select c from Insured c where c.id=:x", Insured.class);
    		query.setParameter("x", name);
    		try {
    			found = query.getSingleResult();
    		} catch (Exception ex) {
    			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
    					"no insured with name=" + name);
    		}
    		return found;
    	}
    	public void modifyInsured(Insured insured)
    	{
    		em.merge(insured);
    		
    	}


}
