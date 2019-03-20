package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {

	
	Instructor tempIn=new Instructor("man","van","man.vinu@gmail.com");
	InstructorDetail tempd=new InstructorDetail("http:luv2gun.com","coding");
	tempIn.setInstructorDetail(tempd);
	session.beginTransaction();
//	save the student object
//	this will also save the details object too because of the CascadeType.All
	session.save(tempIn);
	session.getTransaction().commit();
}finally {
	session.close();
	factory.close();
}
	}
}
