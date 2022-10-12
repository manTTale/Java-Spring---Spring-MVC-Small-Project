package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		//CREATE SESSION
		Session session = factory.getCurrentSession();
		try {		
			//start a transaction
			session.beginTransaction();
			
			//create a course
			System.out.println("Creating the course");
			Course course = new Course("Course big boss");
			//add some reviews
			System.out.println("Creating and adding some courses");			
			Review review1 = new Review("good job");
			Review review2 = new Review("you are doing fine");
			course.addReview(review1);
			course.addReview(review2);
			
			//save the course ... and leverage cascade all
			System.out.println("Saving the course");
			System.out.println(course);
			System.out.println(course.getReviews());
			session.save(course);		
			
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
