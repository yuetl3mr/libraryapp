package view;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import connection.DbConnection;

public class HibernateTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = DbConnection.getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println(System.identityHashCode(session));
	}
}
