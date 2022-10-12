package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			//start a transaction
			session.beginTransaction();
			
			//get the instructor from db
			System.out.println("Getting the instructor from the db");
			int theId=1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//create some courses
			System.out.println("Creating the courses");
			Course course1 = new Course("Title of Course 1");
			Course course2 = new Course("Title of Course 2");
			Course course3 = new Course("Title of Course 3");
			
			//add courses to instructor
			System.out.println("Adding the courses to the instructor");
			tempInstructor.add(course1);
			tempInstructor.add(course2);	
			tempInstructor.add(course3);	
			
			//save the course
			System.out.println("Saving the courses...");
			session.save(course1);		
			session.save(course2);
			session.save(course3);
			
			
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
