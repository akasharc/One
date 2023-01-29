package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Test {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();
		configuration.configure("com/test/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		
		// pass the class name
		Query query = session.createQuery("from Student");
		List<Student>students =query.list();
		for (Student student : students) {
			System.out.println("ID="+ student.getId());
			System.out.println(("City="+student.getCity()));
			System.out.println("Mobile="+student.getMobile());
			System.out.println("Name="+student.getName());
		}
		
		session.close();
		sessionFactory.close();
		
		System.out.println("Record saved successfully.");

	}

}
