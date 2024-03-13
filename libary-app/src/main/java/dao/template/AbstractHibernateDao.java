package dao.template;

import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import connection.DbConnection;

public class AbstractHibernateDao {
	
	private SessionFactory sessionFactory;
	
	public AbstractHibernateDao() {
		sessionFactory = DbConnection.getSessionFactory();
	}
	
	protected Session openSession() {
		return sessionFactory.openSession();
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected void executeWithTransaction(Consumer<Session> consumer) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			consumer.accept(session);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	protected <T> List<T> safeList(Query<?> query) {
		return (List<T>)query.getResultList();
	}

}