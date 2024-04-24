package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.User;

public class HibernateUserDao extends AbstractHibernateDao implements UserDao {
	
	private static final String getAll = "SELECT * FROM user";
	private static final String getMaxId = "SELECT MAX(userId) FROM user";
	private static final String getId = "SELECT * FROM user WHERE userId = :pId";
	
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
	
	@Override
	public User get(Integer id) {
		List<User> users = openSession().createNativeQuery(getId,User.class).setParameter("pId", id).getResultList();
		if(users.isEmpty()) {
			return null;
		}else {
			return users.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		User user = get(integer);
		if(user == null) {
			System.exit(0);
		}
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Integer userId ,String name, String address, String phoneNumber) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			User user = get(userId);
			user.setName(name);
			user.setAddress(address);
			user.setPhoneNumber(phoneNumber);
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
