package com.demo.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.tutorial.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=null;
		try {
		session=sf.getCurrentSession();
		session.beginTransaction();
		int id=3;
		Student st=session.get(Student.class, id);
		st.setFirstName("MdMujahid");
		session.getTransaction().commit();
		System.out.println(st);
		session=sf.getCurrentSession();
		session.beginTransaction();
		System.out.println("update all student");
		session.createQuery("update Student set email='mdmujahid@gamil.com' where firstName='MdMujahid'").executeUpdate();
		System.out.println("done!!!!!!");
		session.getTransaction().commit();
		
		}finally {
			sf.close();
		}

	}

}
