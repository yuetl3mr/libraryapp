package view;

import dao.HibernateManagerSystemDao;
import dao.HibernateUserDao;
import dao.ManagerSystemDao;
import dao.UserDao;
import persistence.User;
import utils.SqlUtils;

public class test {
	private static UserDao userDao;
	private static ManagerSystemDao managerSystemDao;
	static {
		userDao = new HibernateUserDao();
		managerSystemDao = new HibernateManagerSystemDao();
	}
	
	public static void main(String[] args) {
		SqlUtils.generate("test", userDao.getAll());
		SqlUtils.generate("test", managerSystemDao.getAll());
		userDao.save(new User(2,"lehuuquy","abc","123"));
	}
}
