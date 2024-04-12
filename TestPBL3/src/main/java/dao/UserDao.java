package dao;

import java.util.List;

import persistence.User;

public interface UserDao {
	List<User> getAll();
}
