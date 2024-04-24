package dao;

import java.util.List;

import persistence.Issue;

public interface IssueDao {
	List<Issue> getAll();
	
	void save(Issue issue);
	
	Issue get(Integer integer);
	
	void delete(Integer integer);
}
