package com.demo.hibernate.tutorial;

	import org.hibernate.Query;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;
	import org.hibernate.mapping.List;

	public class Retrive {
	    public static void main(String args[]) {
	        Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");// populates the data of the
	                                            // configuration file

	        // creating seession factory object
	        SessionFactory factory = cfg.buildSessionFactory();

	        // creating session object
	        Session session = factory.openSession();

	        // creating transaction object
	        Transaction t = session.beginTransaction();

	        Query query = session.createQuery("from student");
	        java.util.List list = query.list();
	        System.out.println(list);
	        t.commit();
	        session.close();
	    }
	}