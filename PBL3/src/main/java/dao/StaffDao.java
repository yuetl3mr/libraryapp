package dao;

import java.util.List;

import persistence.Staff;

public interface StaffDao {
	List<Staff> getAll();
	
	void save(Staff staff);
	
	Staff get(Integer integer);
	
	void delete(Integer integer);
	
	void update(Integer userId, String dept, Double salary);
}
