package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//CREATE SESSION
		Session session = factory.getCurrentSession();
		try {
			
			//create student object
			System.out.println("Creating new Student object . . . ");
			Student student = new Student("Paul", "Wall", "paul@luv2code.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("Saving the new Student object . . . ");
			session.save(student);
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
