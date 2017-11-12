package services;

import java.util.List;

import javax.ejb.Local;

import domain.User;

@Local
public interface userServiceLocal {
	public List<User> getAllUsers();
	public User findUserByMail(String Mail) ;
}
