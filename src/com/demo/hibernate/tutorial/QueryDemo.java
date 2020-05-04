package com.demo.hibernate.tutorial;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.tutorial.entity.Student;

public class QueryDemo {

	public static void main(String[] args) {
	 
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	Session sessoin=factory.getCurrentSession();
	try {
		System.out.println("read the student information.....");
		sessoin.beginTransaction();
		List<Student> st=sessoin.createQuery("from Student").list();
		dispalyStudentDetail(st);
		
		st=sessoin.createQuery("from Student s where s.firstName='md'").list();
		dispalyStudentDetail(st);
		sessoin.getTransaction().commit();
	} finally {
		factory.close();
	}

	}

	private static void dispalyStudentDetail(List<Student> st) {
		for(Student student:st)
		System.out.println("data is "+student);
	}

}
