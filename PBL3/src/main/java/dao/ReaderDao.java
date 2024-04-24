package dao;

import java.util.List;

import persistence.Reader;

public interface ReaderDao {

	List<Reader> getAll();
	
	void save(Reader reader);
	
	Reader get(Integer integer);
	
	void delete(Integer integer);
}
