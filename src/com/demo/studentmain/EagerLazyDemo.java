package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {
	int i=1;
	session.beginTransaction();
	Instructor d=session.get(Instructor.class, i);
	System.out.println("Instructor:"+d);
	
	System.out.println("courses are:"+d.getCourses());
	
	
	
	session.getTransaction().commit();
}finally {
	factory.close();
}
	}
}
