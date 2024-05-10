package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import java.time.LocalDate;
import persistence.Book;
import persistence.Loan;
import persistence.Reader;
import persistence.Return;

public class HibernateLoanDao extends AbstractHibernateDao implements LoanDao {

    private static final String getAll = "SELECT * FROM loan";
    private static final String get = "SELECT * FROM loan WHERE loanId = :pId";
    private static final String getMaxId = "SELECT MAX(loanId) FROM loan";
    private static final String getReturn = "SELECT loan.*\n"
            + "FROM borrow\n"
            + "JOIN loan\n"
            + "ON borrow.loanId = loan.loanId\n"
            + "WHERE bookId = :pId and `status` = true";

    public Loan getLoan(Integer bookId){
        return openSession().createNativeQuery(getReturn,Loan.class).setParameter("pId", bookId).getResultList().get(0);
    }
    
    @Override
    public List<Loan> getAll() {
        return openSession().createNativeQuery(getAll, Loan.class).getResultList();
    }

    @Override
    public void save(Loan loan) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(loan);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Loan get(Integer integer) {
        List<Loan> loans = openSession().createNativeQuery(get, Loan.class).setParameter("pId", integer).getResultList();
        if (loans.isEmpty()) {
            return null;
        } else {
            return loans.get(0);
        }
    }

    @Override
    public void delete(Integer integer) {
        Loan loan = get(integer);
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(loan);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public Integer maxId() {
        return (Integer) openSession().createNativeQuery(getMaxId).getResultList().get(0);
    }

    public void update(Integer loanId, String note, boolean status) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Loan loan = get(loanId);
            loan.setNote(note);
            loan.setStatus(status);
            session.update(loan);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
