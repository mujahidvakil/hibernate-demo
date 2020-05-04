package com.demo.hibernate.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.hibernate.tutorial.entity.Student;

public class DeleteStudenDemo {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=null;
		try {
			session=sf.getCurrentSession();
			session.beginTransaction();
			//int id=1;
			//Student st=session.get(Student.class, id);
			//session.delete(st);
			session.createQuery("delete from Student where id=3").executeUpdate();
			session.getTransaction().commit();
		}finally {
			sf.close();
		}

	}

}
