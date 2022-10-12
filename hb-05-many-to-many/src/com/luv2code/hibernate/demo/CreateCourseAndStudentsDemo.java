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

public class CreateCourseAndStudentsDemo {

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
			
			//create a course			
			Course course = new Course("Course big boss");
			//add some reviews
			System.out.println("\nSaving the course...");	
			session.save(course);		
			System.out.println("Saved the course: "+course);	
			
			//create students
			System.out.println("\nCreating the students");
			Student student1 = new Student("Ciobanu","Stefan","ciobanu@gmail.com");
			Student student2 = new Student("Roberto","Mantale","mantale@gmail.com");			
			
			//add the students to the course
			course.addStudent(student1);
			course.addStudent(student2);
			
			//save the students
			System.out.println("Saved the student 1: "+student1);
			System.out.println("Saved the student 2: "+student2);
			session.save(student1);
			session.save(student2);
			System.out.println("Saved the students: "+course.getStudents());			
			
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
