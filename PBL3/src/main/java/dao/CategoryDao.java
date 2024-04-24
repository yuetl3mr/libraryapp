package dao;

import java.util.List;

import persistence.Category;

public interface CategoryDao {
	List<Category> getAll();
	
	void save(Category category);
	
	Category get(Integer integer);
	
	void delete(Integer integer);
}
