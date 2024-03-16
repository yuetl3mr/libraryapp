package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Reader;

public class HibernateReaderDao extends AbstractHibernateDao implements ReaderDao {
	
	private static final String Q_GET_ALL_READER = "SELECT * FROM reader";
	
	@Override
	public List<Reader> getAll() {
		Session session = openSession();
		return session.createNativeQuery(Q_GET_ALL_READER, Reader.class).getResultList();
	}
}
