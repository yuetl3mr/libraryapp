package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Issue;
import persistence.Loan;
import persistence.Return;

public class HibernateIssueDao extends AbstractHibernateDao implements IssueDao {
	
	private static final String getAll = "SELECT * FROM issue";
	private static final String get = "SELECT * FROM issue WHERE issueId = :pId";
	
	@Override
	public List<Issue> getAll() {
		return openSession().createNativeQuery(getAll,Issue.class).getResultList();
	}
	
	@Override
	public void save(Issue issue) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(issue);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public Issue get(Integer integer) {
		List<Issue> issues = openSession().createNativeQuery(get,Issue.class).setParameter("pId", integer).getResultList();
		if(issues.isEmpty()) {
			return null;
		}else {
			return issues.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		Issue issue = get(integer);
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(issue);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
