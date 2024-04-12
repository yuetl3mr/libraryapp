package dao;

import java.util.List;

import dao.template.AbstractHibernateDao;
import persistence.User;

public class HibernateUserDao extends AbstractHibernateDao implements UserDao {
	
	private static final String getAllUser = "SELECT * FROM user";

	@Override
	public List<User> getAll() {
		return openSession().createNativeQuery(getAllUser, User.class).getResultList();
	}
}
