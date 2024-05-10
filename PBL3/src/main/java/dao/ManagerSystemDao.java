package dao;

import java.util.List;

import persistence.ManagerSystem;

public interface ManagerSystemDao {
	List<ManagerSystem> getAll();
	
	void save(ManagerSystem managerSystem);
	
	ManagerSystem get(String userNam, String password);
	
	ManagerSystem getById(Integer integer);
	
	void delete(Integer integer);
	
	// chi co chuc nang doi mat khau
	void update(Integer userId, String password);
	
	// sử dụng cho function
	boolean userNameIsEmpty(String userName);
}
