package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Reader;
import persistence.Return;

public class HibernateReaderDao extends AbstractHibernateDao implements ReaderDao {
	
	private static final String getAll = "SELECT * FROM reader";
	private static final String get = "SELECT * FROM reader WHERE userId = :pId";
	
	@Override
	public List<Reader> getAll() {
		return openSession().createNativeQuery(getAll,Reader.class).getResultList();
	}
	
	@Override
	public void save(Reader reader) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(reader);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public Reader get(Integer integer) {
		List<Reader> readers = openSession().createNativeQuery(get,Reader.class).setParameter("pId", integer).getResultList();
		if(readers.isEmpty()) {
			return null;
		}else {
			return readers.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		Reader reader = get(integer);
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(reader);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
