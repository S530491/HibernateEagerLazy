package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Student;

public class CreateCoursesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {

	
//	get instructor from the db
	session.beginTransaction();
	int i=1;
	Instructor in=session.get(Instructor.class, i);
//	create some courses
	Course t1=new Course("air guitar-ultimate guide");
	Course t2=new Course("pinball");
	in.add(t1);
	in.add(t2);
	
	session.save(t1);
	session.save(t2);
//	save the student object
//	this will also save the details object too because of the CascadeType.All
	
	session.getTransaction().commit();
}finally {
	session.close();
	factory.close();
}
	}
}
