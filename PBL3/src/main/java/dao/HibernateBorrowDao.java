package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import dto.BookDto;
import dto.BorrowDto;
import java.time.LocalDate;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LocalDateType;
import org.hibernate.type.StringType;
import persistence.Borrow;
import persistence.Loan;
import persistence.Return;

public class HibernateBorrowDao extends AbstractHibernateDao implements BorrowDao {

    private static final String getAll = "SELECT * FROM borrow";
    private static final String get = "SELECT * FROM borrow WHERE loanId = :pId";
    private static final String getBorrowDto = "SELECT book.bookId as bookId,\n"
            + "	   book.`name` as `name`,\n"
            + "       author as author,\n"
            + "       category.`name` as category,\n"
            + "       releaseTime as borrowingTime,\n"
            + "       dueTime as borrowingPeriod\n"
            + "FROM loan\n"
            + "JOIN borrow\n"
            + "ON loan.loanId = borrow.loanId\n"
            + "JOIN book\n"
            + "ON book.bookId = borrow.bookId\n"
            + "JOIN category\n"
            + "ON category.categoryId = book.categoryId\n"
            + "WHERE borrow.userId = :pId and loan.`status` = 1";

    public List<BorrowDto> getBorrowDto(Integer UserId) {
        return (List<BorrowDto>)openSession().createNativeQuery(getBorrowDto)
                .setParameter("pId", UserId)
                .addScalar("bookId",IntegerType.INSTANCE )
                .addScalar("name", StringType.INSTANCE)
                .addScalar("author",StringType.INSTANCE )
                .addScalar("category",StringType.INSTANCE )
                .addScalar("borrowingTime", LocalDateType.INSTANCE)
                .addScalar("borrowingPeriod",LocalDateType.INSTANCE )
                .setResultTransformer(Transformers.aliasToBean(BorrowDto.class)).getResultList();
    }

    @Override
    public List<Borrow> getAll() {
        return openSession().createNativeQuery(getAll, Borrow.class).getResultList();
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
        List<Borrow> borrows = openSession().createNativeQuery(get, Borrow.class).setParameter("pId", integer).getResultList();
        if (borrows.isEmpty()) {
            return null;
        } else {
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
