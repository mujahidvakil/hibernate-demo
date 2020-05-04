package com.demo.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.tutorial.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
	 
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	Session sessoin=factory.getCurrentSession();
	try {
		Student st=new Student("Md","Ansari","mujahid7851@gmail.com");
		Student st1=new Student("Mujahid","Ansari","mujahid7851@gmail.com");
		sessoin.beginTransaction();
		sessoin.save(st);
		sessoin.save(st1);
		sessoin.getTransaction().commit();
	} finally {
		factory.close();
	}

	}

}
