package dao;

import java.time.LocalDate;
import java.util.List;

import persistence.Book;

public interface BookDao {
        
        Integer maxId();
    
	List<Book> getAll();
	
	List<Book> getAllFindName(String string);
	
	List<Book> getAllFindCategory(String string);
        
        List<Book> getAllFindAuthor(String string);
        
        List<Book> getAllFindCategoryId(Integer integer);
        
        List<Book> getBookId(Integer integer);
	
	void save(Book book);
	
	Book get(Integer integer);
	
	void delete(Integer integer);
	
	void update(Integer bookId, Integer categoryId, String name, String author,LocalDate publication,boolean status);
        
        void saveAmount(Integer categoryId, String name, String author,LocalDate publication,boolean status, Integer amount);
	
	List<Book> getAllFindNameAndCategory(String name, String category);
        
        Integer totalBook();
}
