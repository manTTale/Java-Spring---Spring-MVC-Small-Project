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
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForOneStudentDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//CREATE SESSION
		Session session = factory.getCurrentSession();
		try {		
			//start a transaction
			session.beginTransaction();
			
			//get the student mary from the database
			int theId=1;
			Student student = session.get(Student.class, theId);
			
			//create more courses
			Course course1 = new Course("Course course course");
			Course course2 = new Course("Course course");			
			
			//add the student to courses
			course1.addStudent(student);
			course2.addStudent(student);
			
			//save the courses
			session.save(course1);
			session.save(course2);			
			
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
