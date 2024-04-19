package dao;

import java.util.List;

import aaa.user;
import dao.template.AbstractHibernateDao;

public class HibernateUserDaoaaa extends AbstractHibernateDao implements UserDaoaaa {
	
	private static final String getAll = "SELECT * FROM user";
	private static final String getEmail = "SELECT email FROM `user` WHERE id = :pid";
	private static final String getTenNguoiDung = "SELECT tennguoidung FROM `user` WHERE id = :pid";
	private static final String getDiaChi = "SELECT diachi FROM `user` WHERE id = :pid";
	
	@Override
	public List<user> users() {
		return openSession().createNativeQuery(getAll, user.class).getResultList();
	}
	
	@Override
	public String getEmail(Integer id) {
		return (String)openSession().createNativeQuery(getEmail).setParameter("pid", id).getSingleResult();
	}
	@Override
	public String getTenNguoiDung(Integer id) {
		// TODO Auto-generated method stub
		return (String)openSession().createNativeQuery(getTenNguoiDung).setParameter("pid", id).getSingleResult();
	}
	@Override
	public String getDiaChi(Integer id) {
		// TODO Auto-generated method stub
		return (String)openSession().createNativeQuery(getDiaChi).setParameter("pid", id).getSingleResult();
	}
}
