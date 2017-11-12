package services;

import java.util.List;

import javax.ejb.Remote;

import domain.User;


@Remote
public interface UserServiceRemote {
	void createUser(User user);
	List<User> findAllUsers();
	User authenticate(String login, String password);
}
