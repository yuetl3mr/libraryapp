package dao;

import java.util.List;

import persistence.ManagerSystem;

public interface ManagerSystemDao {
	List<ManagerSystem> getAll();
	
	void save(ManagerSystem managerSystem);
	
	ManagerSystem get(String userNam, String password);
}
