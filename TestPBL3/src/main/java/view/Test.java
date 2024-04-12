package view;

import org.hibernate.Session;

import connection.DbConnection;

public class Test {
	public static void main(String[] args) {
		Session session = DbConnection.getSessionFactory().getCurrentSession();
		System.out.println(session);
	}
}
