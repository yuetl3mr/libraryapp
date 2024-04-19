package dao;

import java.util.List;

import aaa.user;

public interface UserDaoaaa {
	List<user> users();
	
	String getEmail(Integer id);
	
	String getTenNguoiDung(Integer id);
	
	String getDiaChi(Integer id);
}
