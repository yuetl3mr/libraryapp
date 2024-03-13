package view;

import dao.HibernateUserDao;
import dao.UserDao;
import utils.SqlUtils;

public class Hibernate {
	
	private static UserDao userDao;
	
	static {
		userDao = new HibernateUserDao();
	}
	
	public static void main(String[] args) {
		SqlUtils.generate("chill chill", userDao.getAll());
	}
}
