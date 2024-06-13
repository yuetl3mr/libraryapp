package dao;

import java.util.List;
import persistence.Reader;

import persistence.User;

public interface UserDao {
	List<User> getAll();
	
	void save(User user);
	
	Integer maxId();
	
	User get(Integer id);
        
        List<User> getUserId(Integer id);
	
	void delete(Integer integer);
	
	void update(Integer userId ,String name, String address, String phoneNumber);
        
        List<User> getAllReader();
        
        List<User> getAllFindNameReader(String Name);
        
        boolean isEmptyEmail(String string);
	
	// sử dụng cho function
	
	
}
