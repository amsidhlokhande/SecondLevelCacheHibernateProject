package com.amsidh.hibernate.app;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user = (UserDetails) session.get(UserDetails.class, 2);
		System.out.println(user.getUserName());
		session.getTransaction().commit();
		session.close();

		Session session2=sessionFactory.openSession();
		session2.beginTransaction();
		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 2);
		System.out.println(user2.getUserName());

		session2.getTransaction().commit();
		session2.close();

	}

}
