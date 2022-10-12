	package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Daffy", "Duck", "daffy@luv2code.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			System.out.println("Saving the new Student object . . . ");
			System.out.println(student);
			session.save(student);
			//commit transaction
			session.getTransaction().commit();		
			
			//find out what the primary key is
			System.out.println("Saved student id" +student.getId());
			
			//get a new session
			session=factory.getCurrentSession();
			session.beginTransaction();
			//start a transaction
			System.out.println("\nGetting student with the id of: "+ student.getId());
			//retrieve student based on the id: primary key
			Student studentRead = session.get(Student.class, student.getId());
			System.out.println("Get complete"+studentRead	);
			//commit the transaction
			session.getTransaction().commit();		
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
	}

}
