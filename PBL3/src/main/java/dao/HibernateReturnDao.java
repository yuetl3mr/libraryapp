package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import org.hibernate.query.NativeQuery;
import persistence.Return;
import persistence.Review;

public class HibernateReturnDao extends AbstractHibernateDao implements ReturnDao {

    private static final String getAll = "SELECT * FROM `return`";
    private static final String get = "SELECT * FROM `return` WHERE loanId = :pId";
    //private static final String saveReturn = "INSERT INTO `return` (bookId, returnTime, staffId, userId, loanId) VALUES (:pbookId, :preturnTime, :pstaffId, :puserId, :ploanId)";
    private static final String saveReturn = "INSERT INTO `return` (loanId, userId, bookId, staffId, returnTime) VALUES (:ploanId, :puserId, :pbookId, :pstaffId, :preturnTime)";

    @Override
    public List<Return> getAll() {
        return openSession().createNativeQuery(getAll, Return.class).getResultList();
    }

//	@Override
//	public void save(Return return1) {
//		Session session = openSession();
//		Transaction transaction = session.beginTransaction();
//		try {
//			session.save(return1);
//			transaction.commit();
//		} catch (Exception e) {
//			transaction.rollback();
//			e.printStackTrace();
//		}
//	}
    @Override
    public void save(Return returnObj) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            NativeQuery<?> query = session.createNativeQuery(saveReturn);
            query.setParameter("ploanId", returnObj.getLoanId())
                    .setParameter("puserId", returnObj.getUserId())
                    .setParameter("pbookId", returnObj.getBookId())
                    .setParameter("pstaffId", returnObj.getStaffId())
                    .setParameter("preturnTime", returnObj.getReturnTime());
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Return get(Integer integer) {
        List<Return> returns = openSession().createNativeQuery(get, Return.class).setParameter("pId", integer).getResultList();
        if (returns.isEmpty()) {
            return null;
        } else {
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
