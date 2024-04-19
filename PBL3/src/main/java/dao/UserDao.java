package dao;

import java.util.List;

import persistence.User;

public interface UserDao {
	List<User> getAll();
	
	void save(User user);
	
	Integer maxId();
}
