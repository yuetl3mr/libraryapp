package dao;

import java.util.List;

import persistence.User;

public interface UserDao {
	List<User> getAll();
	
	void save(User user);
	
	Integer maxId();
	
	User get(Integer id);
	
	void delete(Integer integer);
	
	void update(Integer userId ,String name, String address, String phoneNumber);
	
	// sử dụng cho function
	
	
}
