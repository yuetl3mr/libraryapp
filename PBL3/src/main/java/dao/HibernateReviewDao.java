package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Review;
import persistence.Staff;

public class HibernateReviewDao extends AbstractHibernateDao implements ReviewDao {
	
	private static final String getAll = "SELECT * FROM review";
	private static final String get = "SELECT * FROM review WHERE reviewId = :pId";
	
	@Override
	public List<Review> getAll() {
		return openSession().createNativeQuery(getAll,Review.class).getResultList();
	}
	
	@Override
	public void save(Review review) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(review);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public Review get(Integer integer) {
		List<Review> reviews = openSession().createNativeQuery(get,Review.class).setParameter("pId", integer).getResultList();
		if(reviews.isEmpty()) {
			return null;
		}else {
			return reviews.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		Review review = get(integer);
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(review);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
