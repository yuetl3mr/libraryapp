package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.User;

public class HibernateUserDao extends AbstractHibernateDao implements UserDao {
	
	private static final String getAll = "SELECT * FROM user";
	private static final String getMaxId = "SELECT MAX(userId) FROM user";
	
	@Override
	public List<User> getAll() {
		return openSession().createNativeQuery(getAll,User.class).getResultList();
	}
	
	@Override
	public void save(User user) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public Integer maxId() {
		return (Integer)openSession().createNativeQuery(getMaxId).getResultList().get(0);
	}
}
