package dao;

import java.util.List;

import persistence.Loan;

public interface LoanDao {
	List<Loan> getAll();
	
	void save(Loan loan);
	
	Loan get(Integer integer);
	
	void delete(Integer integer);
        
        Integer maxId();
}
