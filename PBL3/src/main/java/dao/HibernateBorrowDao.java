package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Borrow;
import persistence.Loan;
import persistence.Return;

public class HibernateBorrowDao extends AbstractHibernateDao implements BorrowDao {
	
	private static final String getAll = "SELECT * FROM borrow";
	private static final String get = "SELECT * FROM borrow WHERE loanId = :pId";
	
	@Override
	public List<Borrow> getAll() {
		return openSession().createNativeQuery(getAll,Borrow.class).getResultList();
	}
	
	@Override
	public void save(Borrow borrow) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(borrow);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public Borrow get(Integer integer) {
		List<Borrow> borrows = openSession().createNativeQuery(get,Borrow.class).setParameter("pId", integer).getResultList();
		if(borrows.isEmpty()) {
			return null;
		}else {
			return borrows.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		Borrow borrow = get(integer);
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(borrow);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
