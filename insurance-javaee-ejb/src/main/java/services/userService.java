package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.Reunion;
import domain.User;

/**
 * Session Bean implementation class userService
 */
@Stateless
@LocalBean
public class userService implements userServiceRemote, userServiceLocal {
	
	@PersistenceContext
	private EntityManager em ;
    /**
     * Default constructor. 
     */
    public userService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<User> getAllUsers() {
		return em.createQuery("select r from User r", User.class)
				.getResultList();
	}

	@Override
	public User findUserByMail(String Mail) {
		return em.createQuery("select r from User r where r.mail=?x", User.class)
				.setParameter(1, Mail).getSingleResult();
	}

}
