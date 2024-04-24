package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Return;
import persistence.Review;

public class HibernateReturnDao extends AbstractHibernateDao implements ReturnDao {
	
	private static final String getAll = "SELECT * FROM `return`";
	private static final String get = "SELECT * FROM `return` WHERE loanId = :pId";
	
	@Override
	public List<Return> getAll() {
		return openSession().createNativeQuery(getAll,Return.class).getResultList();
	}
	
	@Override
	public void save(Return return1) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(return1);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public Return get(Integer integer) {
		List<Return> returns = openSession().createNativeQuery(get,Return.class).setParameter("pId", integer).getResultList();
		if(returns.isEmpty()) {
			return null;
		}else {
			return returns.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		Return return1 = get(integer);
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(return1);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

}
