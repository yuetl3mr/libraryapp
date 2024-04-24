package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.template.AbstractHibernateDao;
import persistence.Staff;
import persistence.User;

public class HibernateStaffDao extends AbstractHibernateDao implements StaffDao {
	
	private static final String getAll = "SELECT * FROM staff"; 
	private static final String get = "SELECT * FROM staff WHERE userId = :pId";
	
	@Override
	public List<Staff> getAll() {
		return openSession().createNativeQuery(getAll,Staff.class).getResultList();
	}
	
	@Override
	public void save(Staff staff) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(staff);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public Staff get(Integer integer) {
		List<Staff> staffs = openSession().createNativeQuery(get,Staff.class).setParameter("pId", integer).getResultList();
		if(staffs.isEmpty()) {
			return null;
		}else {
			return staffs.get(0);
		}
	}
	
	@Override
	public void delete(Integer integer) {
		Staff staff = get(integer);
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.delete(staff);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(Integer userId, String dept, Double salary) {
		Session session = openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Staff staff = get(userId);
			staff.setDept(dept);
			staff.setSalary(salary);
			session.update(staff);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
}
