package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.User;

public class HibernateUserDao extends AbstractHibernateDao implements UserDao {
	
	private static final String Q_GET_ALL_USER = "SELECT * FROM user";
	
	@Override
	public List<User> getAll() {
		Session session = openSession();
		return session.createNativeQuery(Q_GET_ALL_USER, User.class)
				.getResultList();
	}
}
