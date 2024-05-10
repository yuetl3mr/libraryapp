package dao;

import java.util.List;

import persistence.Borrow;
import dto.BorrowDto;

public interface BorrowDao {

	List<Borrow> getAll();
	
	void save(Borrow borrow);
	
	Borrow get(Integer integer);
	
	void delete(Integer integer);
        
        List<BorrowDto> getBorrowDto(Integer UserId);
}
