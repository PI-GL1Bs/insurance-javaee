package services;

import java.util.List;

import javax.ejb.Local;

import domain.User;


@Local
public interface UserServiceLocal {
	void createUser(User user);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	boolean loginExists(String login);
	void updateInc(String login, String password);
}
