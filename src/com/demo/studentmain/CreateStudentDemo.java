package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {
//	use the session to save the object
//	create a student object
	Student temp=new Student("Paul","Wall","mani@gmail.com");
//	start a transcation
	session.beginTransaction();
//	save the student object
	session.save(temp);
//	commit the transaction
	session.getTransaction().commit();
	System.out.println("saved!!");
}finally {
	factory.close();
}
	}
}
