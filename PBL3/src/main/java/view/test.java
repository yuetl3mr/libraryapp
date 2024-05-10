package view;

import dao.BookDao;
import dao.BorrowDao;
import dao.CategoryDao;
import dao.HibernateBookDao;
import dao.HibernateBorrowDao;
import dao.HibernateCategoryDao;
import dao.HibernateIssueDao;
import dao.HibernateLoanDao;
import dao.HibernateManagerSystemDao;
import dao.HibernateReaderDao;
import dao.HibernateReturnDao;
import dao.HibernateReviewDao;
import dao.HibernateStaffDao;
import dao.HibernateUserDao;
import dao.IssueDao;
import dao.LoanDao;
import dao.ManagerSystemDao;
import dao.ReaderDao;
import dao.ReturnDao;
import dao.ReviewDao;
import dao.StaffDao;
import dao.UserDao;
import dao.BookDtoDao;
import dao.HibernateBookDtoDao;
import java.time.LocalDate;
import utils.SqlUtils;
import utils.Zdata;

public class test {

    private static UserDao userDao;
    private static ManagerSystemDao managerSystemDao;
    private static CategoryDao categoryDao;
    private static BookDao bookDao;
    private static ReaderDao readerDao;
    private static StaffDao staffDao;
    private static ReviewDao reviewDao;
    private static LoanDao loanDao;
    private static BorrowDao borrowDao;
    private static ReturnDao returnDao;
    private static IssueDao issueDao;
    private static BookDtoDao bookDtoDao;

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
    }

    public static void main(String[] args) {
//		SqlUtils.generate("test", userDao.getAll());
//		SqlUtils.generate("test", managerSystemDao.getAll());
//		SqlUtils.generate("test", categoryDao.getAll());
//		SqlUtils.generate("test", bookDao.getAll());
//		SqlUtils.generate("test", readerDao.getAll());
//		SqlUtils.generate("test", staffDao.getAll());
//		SqlUtils.generate("test", reviewDao.getAll());
//		SqlUtils.generate("test", loanDao.getAll());
//		SqlUtils.generate("test", borrowDao.getAll());
//		SqlUtils.generate("test", returnDao.getAll());
//		SqlUtils.generate("test", issueDao.getAll());
//		SqlUtils.generate("test", bookDao.getAllFindCategory("Non-Fiction"));
//		SqlUtils.generate("test", userDao.getAll());
//		userDao.update(10, "Hoang Kim Thach", "Quang Tri", "00000");
//		SqlUtils.generate("test", userDao.getAll());
//		System.out.println(managerSystemDao.userNameIsEmpty("lehuuquy"));
//		System.out.println(managerSystemDao.get("admin", "adminpass"));
//              System.out.println(bookDao.totalBook());
        //bookDao.saveAmount(Integer.BYTES, string, string1, LocalDate.MIN, true, Integer.BYTES);
//                SqlUtils.generate("test", bookDtoDao.getAll());

//                System.out.println(Zdata.loanDao.maxId());
//        SqlUtils.generate("test", bookDao.getAllBorrowBookById(3));
//           SqlUtils.generate("test",borrowDao.getBorrowDto(3));
//            System.err.println(loanDao.getLoan(8));
            managerSystemDao.update(4, "123");
//            userDao.update(5, "Hoang Kim Thach", "Quang Tri", "00000");
            // System.out.println(managerSystemDao.getById(1));
    }
}
