package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Book;
import persistence.Loan;
import persistence.Return;

public class HibernateBookDao extends AbstractHibernateDao implements BookDao {
	
	private static final String getAll = "SELECT * FROM book";
	private static final String get = "SELECT * FROM book WHERE bookId = :pId";
	private static final String findName = "SELECT * FROM book WHERE `name` LIKE :pString";
	private static final String findCategory = "SELECT b.* \r\n"
											 + "FROM book b \r\n"
											 + "INNER JOIN category c ON b.categoryId = c.categoryId \r\n"
											 + "WHERE c.name = :pCategoryName";
	
	@Override
	public List<Book> getAllFindName(String string) {
		return openSession().createNativeQuery(findName,Book.class).setParameter("pString", "%"+string+"%").getResultList();
	}
	
	@Override
	public List<Book> getAll() {
		return openSession().createNativeQuery(getAll, Book.class).getResultList();
	}
	
	
	@Override
	public List<Book> getAllFindCategory(String string) {
		return openSession().createNativeQuery(findCategory,Book.class).setParameter("pCategoryName", string).getResultList();
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
		List<Book> books = openSession().createNativeQuery(get,Book.class).setParameter("pId", integer).getResultList();
		if(books.isEmpty()) {
			return null;
		}else {
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
}
