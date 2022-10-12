package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		//CREATE SESSION
		Session session = factory.getCurrentSession();
		try {
			//create the objects
			
			Instructor instructor = new Instructor("Chad","Darby","darby@luv2code.com");
			InstructorDetail instructorDetail = new InstructorDetail("luv2code.com","luv 2 code!!");
			
			//associate the objects
			
			instructor.setInstructorDetail(instructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor		
			System.out.println("Savint the instructor: "+instructor);
			session.save(instructor);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
