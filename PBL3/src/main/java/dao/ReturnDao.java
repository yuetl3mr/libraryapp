package dao;

import java.util.List;

import persistence.Return;

public interface ReturnDao {
	List<Return> getAll();
	
	void save(Return return1);
	
	Return get(Integer integer);
	
	void delete(Integer integer);
}
