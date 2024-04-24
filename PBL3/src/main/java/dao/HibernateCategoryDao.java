package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Category;
import persistence.Loan;
import persistence.Return;

public class HibernateCategoryDao extends AbstractHibernateDao implements CategoryDao {
	
	private static final String getAll = "SELECT * FROM category";
	private static final String get = "SELECT * FROM category WHERE categoryId = :pId";
	@Override
	public List<Category> getAll() {
		return openSession().createNativeQuery(getAll,Category.class).getResultList();
	}
	
	@Override
	public void save(Category category) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(category);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public Category get(Integer integer) {
		List<Category> categories = openSession().createNativeQuery(get,Category.class).setParameter("pId", integer).getResultList();
		if(categories.isEmpty()) {
			return null;
		}else {
			return categories.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		Category category = get(integer);
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(category);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
