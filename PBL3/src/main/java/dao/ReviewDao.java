package dao;

import java.util.List;

import persistence.Review;

public interface ReviewDao {
	List<Review> getAll();
	
	void save(Review review);
	
	Review get(Integer integer);
	
	void delete(Integer integer);
}
