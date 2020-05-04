package com.demo.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.tutorial.entity.Student;

public class ReadStudentData {

	public static void main(String[] args) {
	 
	SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
	Session sessoin=factory.getCurrentSession();
	try {
		System.out.println("insert data into student table");
		//Student st=new Student("MdMujahid","Ansari","mujahid7851@gmail.com");
		sessoin.beginTransaction();
		Student student=sessoin.get(Student.class,1);
		System.out.println("data is "+student.getFirstName());
		sessoin.getTransaction().commit();
	} finally {
		factory.close();
	}

	}

}
