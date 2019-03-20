package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {
//	create objects
//	Instructor tempIn=new Instructor("siri","vinu","siri.vinu@gmail.com");
//	InstructorDetail tempd=new InstructorDetail("http:luv2.com","coding");
//	tempIn.setInstructorDetail(tempd);
////	associate the objects
//	
////	start a transcation
//	session.beginTransaction();
////	save the student object
////	this will also save the details object too because of the CascadeType.All
//	session.save(tempIn);
//	
////	commit the transaction
//	session.getTransaction().commit();
	System.out.println("saved!!");
	Session session1=factory.getCurrentSession();
	Instructor tempIn1=new Instructor("van","vinu","van.vinu@gmail.com");
	InstructorDetail tempd1=new InstructorDetail("http:luv2gu.com","coding");
	tempIn1.setInstructorDetail(tempd1);
	session1.beginTransaction();
//	save the student object
//	this will also save the details object too because of the CascadeType.All
	session1.save(tempIn1);
	session1.getTransaction().commit();
}finally {
	factory.close();
}
	}
}
