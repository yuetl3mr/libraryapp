package aaa;

import java.util.List;

import dao.HibernateUserDaoaaa;
import dao.UserDaoaaa;

public class test {
	private static UserDaoaaa userDaoaaa;
	static {
		userDaoaaa = new HibernateUserDaoaaa();
	}
	
	public static void main(String[] args) {
		List<aaa.user> userList = userDaoaaa.users();
        for (aaa.user user : userList) {
            System.out.println(user); // In ra thông tin của từng user
        }
	}
}
