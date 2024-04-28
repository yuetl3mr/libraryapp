package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Book;

public interface BookDao {
	List<Book> getAll();
	
	List<Book> getAllFindName(String string);
	
	List<Book> getAllFindCategory(String string);
	
	void save(Book book);
	
	Book get(Integer integer);
	
	void delete(Integer integer);
	
	void update(Integer bookId, Integer categoryId, String name, String author,LocalDate publication,boolean status);
	
	List<Book> getAllFindNameAndCategory(String name, String category);
        
        Integer totalBook();
}
