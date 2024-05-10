package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import java.math.BigInteger;
import persistence.Book;
import persistence.Loan;
import persistence.Return;

public class HibernateBookDao extends AbstractHibernateDao implements BookDao {

    private static final String getAll = "SELECT * FROM book";
    private static final String get = "SELECT * FROM book WHERE bookId = :pId";
    private static final String findName = "SELECT * FROM book WHERE `name` LIKE :pString";
    private static final String findAuthor = "SELECT * FROM book WHERE `author` LIKE :pAuthor";
    private static final String findCategoryId = "SELECT * FROM book WHERE categoryId = :pCategoryId";
    private static final String findCategory = "SELECT b.* \r\n"
            + "FROM book b \r\n"
            + "INNER JOIN category c ON b.categoryId = c.categoryId \r\n"
            + "WHERE c.name = :pCategoryName";
    private static final String findCategoryAndName = "SELECT BOOK.* \r\n"
            + "FROM BOOK\r\n"
            + "JOIN CATEGORY ON BOOK.categoryId = CATEGORY.categoryId\r\n"
            + "WHERE BOOK.name LIKE :pName AND CATEGORY.name LIKE :pCategory";

    private static final String totalBook = "SELECT count(*) FROM book";
    private static final String getMaxId = "SELECT MAX(bookId) FROM book";
    private static final String getAllBorrowById = "SELECT book.*\n"
            + "FROM loan\n"
            + "JOIN borrow\n"
            + "ON loan.loanId = borrow.loanId\n"
            + "JOIN book\n"
            + "on book.bookId = borrow.bookId\n"
            + "WHERE borrow.userId = :pId and loan.`status` = 1";

    @Override
    public List<Book> getAllFindName(String string) {
        return openSession().createNativeQuery(findName, Book.class).setParameter("pString", "%" + string + "%").getResultList();
    }

    @Override
    public List<Book> getAll() {
        return openSession().createNativeQuery(getAll, Book.class).getResultList();
    }

    @Override
    public List<Book> getAllFindCategory(String string) {
        return openSession().createNativeQuery(findCategory, Book.class).setParameter("pCategoryName", string).getResultList();
    }

    public List<Book> getAllFindAuthor(String string) {
        return openSession().createNativeQuery(findAuthor, Book.class).setParameter("pAuthor", "%" + string + "%").getResultList();
    }

    public List<Book> getAllFindCategoryId(Integer integer) {
        return openSession().createNativeQuery(findCategoryId, Book.class).setParameter("pCategoryId", integer).getResultList();
    }

    public List<Book> getBookId(Integer integer) {
        List<Book> books = openSession().createNativeQuery(get, Book.class).setParameter("pId", integer).getResultList();
        return books;
    }

    @Override
    public void save(Book book) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Book get(Integer integer) {
        List<Book> books = openSession().createNativeQuery(get, Book.class).setParameter("pId", integer).getResultList();
        if (books.isEmpty()) {
            return null;
        } else {
            return books.get(0);
        }
    }

    @Override
    public void delete(Integer integer) {
        Book book = get(integer);
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer bookId, Integer categoryId, String name, String author, LocalDate publication,
            boolean status) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Book book = get(bookId);
            book.setCategoryId(categoryId);
            book.setName(name);
            book.setAuthor(author);
            book.setPublication(publication);
            book.setStatus(status);
            session.update(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public void saveAmount(Integer categoryId, String name, String author, LocalDate publication, boolean status, Integer amount) {
        for (int i = 0; i < +amount; i++) {
            Integer maxId = maxId() + 1;
            Book book = new Book(maxId, categoryId, name, author, publication, true);
            save(book);
        }
    }

    @Override
    public List<Book> getAllFindNameAndCategory(String name, String category) {
        return openSession().createNativeQuery(findCategoryAndName, Book.class).setParameter("pName", "%" + name + "%").setParameter("pCategory", "%" + category + "%").getResultList();
    }

    public Integer totalBook() {
        BigInteger bigInteger = (BigInteger) openSession().createNativeQuery(totalBook).getResultList().get(0);
        return bigInteger.intValue();
    }

    @Override
    public Integer maxId() {
        return (Integer) openSession().createNativeQuery(getMaxId).getResultList().get(0);
    }

    public void setFalse(Integer BookId) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Book book = get(BookId);
            book.setStatus(false);
            session.update(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
    
    public void setTrue(Integer BookId) {
        Session session = openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Book book = get(BookId);
            book.setStatus(true);
            session.update(book);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Book> getAllBorrowBookById(Integer userId) {
        return openSession().createNativeQuery(getAllBorrowById, Book.class).setParameter("pId", userId).getResultList();
    }

}
