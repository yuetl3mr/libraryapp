/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dao.BookDao;
import dao.BookDtoDao;
import dao.BorrowDao;
import dao.CategoryDao;
import dao.HibernateBookDao;
import dao.HibernateBookDtoDao;
import dao.HibernateBorrowDao;
import dao.HibernateCategoryDao;
import dao.HibernateIssueDao;
import dao.HibernateLoanDao;
import dao.HibernateManagerSystemDao;
import dao.HibernateReaderDao;
import dao.HibernateReturnDao;
import dao.HibernateReviewDao;
import dao.HibernateStaffDao;
import dao.HibernateTransactionDao;
import dao.HibernateUserDao;
import dao.IssueDao;
import dao.LoanDao;
import dao.ManagerSystemDao;
import dao.ReaderDao;
import dao.ReturnDao;
import dao.ReviewDao;
import dao.StaffDao;
import dao.TransactionDao;
import dao.UserDao;

/**
 *
 * @author 84775
 */
public class Zdata {
        public static UserDao userDao;
	public static ManagerSystemDao managerSystemDao;
	public static CategoryDao categoryDao;
	public static BookDao bookDao;
	public static ReaderDao readerDao;
	public static StaffDao staffDao;
	public static ReviewDao reviewDao;
	public static LoanDao loanDao;
	public static BorrowDao borrowDao;
	public static ReturnDao returnDao;
	public static IssueDao issueDao;
        public static BookDtoDao bookDtoDao;
        public static TransactionDao transactionDao;
	static {
		userDao = new HibernateUserDao();
		managerSystemDao = new HibernateManagerSystemDao();
		categoryDao = new HibernateCategoryDao();
		bookDao = new HibernateBookDao();
		readerDao = new HibernateReaderDao();
		staffDao = new HibernateStaffDao();
		reviewDao = new HibernateReviewDao();
		loanDao = new HibernateLoanDao();
		borrowDao = new HibernateBorrowDao();
		returnDao = new HibernateReturnDao();
		issueDao = new HibernateIssueDao();
                bookDtoDao = new HibernateBookDtoDao();
                transactionDao = new HibernateTransactionDao();
	}
}
