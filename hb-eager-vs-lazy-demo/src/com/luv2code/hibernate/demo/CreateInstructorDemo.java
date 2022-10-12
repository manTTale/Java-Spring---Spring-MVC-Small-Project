	package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		//CREATE SESSION
		Session session = factory.getCurrentSession();
		try {
			//create the objects
			
			Instructor tempInstructor = new Instructor("Susan","Public","susan@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com","Video games");
			
			//associate the objects
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//start a transaction
			session.beginTransaction();
			
			//save the instructor		
			System.out.println("Saving the instructor: "+tempInstructor);
			session.save(tempInstructor);
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
		
	}

}
