package dao;

import java.util.List;

import persistence.Borrow;

public interface BorrowDao {

	List<Borrow> getAll();
	
	void save(Borrow borrow);
	
	Borrow get(Integer integer);
	
	void delete(Integer integer);
}
