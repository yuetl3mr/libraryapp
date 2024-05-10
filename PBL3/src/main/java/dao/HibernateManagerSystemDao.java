package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.ManagerSystem;
import persistence.Reader;

public class HibernateManagerSystemDao extends AbstractHibernateDao implements ManagerSystemDao {
	
	private static final String getAll = "SELECT * FROM managersystem";
	private static final String get = "SELECT * FROM managersystem WHERE userName = :pUserName and password = :pPassword";
	private static final String getById = "SELECT * FROM managersystem WHERE userId = :pId";
	private static final String isEmpty = "SELECT * FROM managersystem WHERE userName = :pUserName"; 
	
	@Override
	public List<ManagerSystem> getAll() {
		return openSession().createNativeQuery(getAll,ManagerSystem.class).getResultList();
	}
	
	@Override
	public void save(ManagerSystem managerSystem) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(managerSystem);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public ManagerSystem get(String userName, String password) {
		List<ManagerSystem> managerSystems =  openSession().createNativeQuery(get,ManagerSystem.class)
				.setParameter("pUserName", userName)
				.setParameter("pPassword", password)
				.getResultList();
		if(managerSystems.isEmpty()) {
			return null;
		}else {
			return managerSystems.get(0);
		}
	}
	
	@Override
	public ManagerSystem getById(Integer integer) {
		List<ManagerSystem> managerSystems = openSession().createNativeQuery(getById,ManagerSystem.class).setParameter("pId", integer).getResultList();
		if(managerSystems.isEmpty()) {
			return null;
		}else {
			return managerSystems.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		ManagerSystem managerSystem = getById(integer);
		if(managerSystem == null) {
			System.exit(0);
		}
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(managerSystem);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Integer userId, String password) {
		Session session = openSession();
		Transaction transaction = openSession().beginTransaction();
		try {
			ManagerSystem managerSystem = getById(userId);
			managerSystem.setPassword(password);
			session.update(managerSystem);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean userNameIsEmpty(String userName) {
		List<ManagerSystem> managerSystems =  openSession().createNativeQuery(isEmpty,ManagerSystem.class)
				.setParameter("pUserName", userName)
				.getResultList();
		if(managerSystems.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
