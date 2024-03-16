package view;

import dao.HibernateReaderDao;
import dao.HibernateUserDao;
import dao.ReaderDao;
import dao.UserDao;
import utils.SqlUtils;

public class Hibernate {
	
	private static UserDao userDao;
	private static ReaderDao readerDao;
	
	static {
		userDao = new HibernateUserDao();
		readerDao = new HibernateReaderDao();
	}
	
	public static void main(String[] args) {
		SqlUtils.generate("chill chill", userDao.getAll());
		SqlUtils.generate("chill chill phan 2",readerDao.getAll());
	}
}
