package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {
	int i=1;

//	Hibernate query with hql

	session.beginTransaction();
	Query<Instructor> q=session.createQuery("select i from Instructor i "+
	"JOIN FETCH i.courses "+"where i.id=:the",
			Instructor.class);
	q.setParameter("the", i);
	Instructor d=q.getSingleResult();
	System.out.println("Instructor:"+d);
	System.out.println(d.getCourses());
		
	
	
	
	session.getTransaction().commit();
}finally {
	factory.close();
}
	}
}
