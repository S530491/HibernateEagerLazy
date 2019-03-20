package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {
	int i=1;
	session.beginTransaction();
	InstructorDetail d=session.get(InstructorDetail.class, i);
	System.out.println(d);
	System.out.println(d.getInstructor());
	
	
	
	session.getTransaction().commit();
}finally {
	factory.close();
}
	}
}
