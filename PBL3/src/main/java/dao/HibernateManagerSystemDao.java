package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.ManagerSystem;

public class HibernateManagerSystemDao extends AbstractHibernateDao implements ManagerSystemDao {
	
	private static final String getAll = "SELECT * FROM managersystem";
	private static final String get = "SELECT * FROM managersystem WHERE userName = :pUserName and password = :pPassword";
	
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
	public ManagerSystem get(String userNam, String password) {
		List<ManagerSystem> managerSystems =  openSession().createNativeQuery(get,ManagerSystem.class)
				.setParameter("pUserName", userNam)
				.setParameter("pPassword", password)
				.getResultList();
		if(managerSystems.isEmpty()) {
			return null;
		}else {
			return managerSystems.get(0);
		}
	}
}
