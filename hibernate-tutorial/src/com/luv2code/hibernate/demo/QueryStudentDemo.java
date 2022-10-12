package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//CREATE SESSION
		Session session = factory.getCurrentSession();
		try {
			
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			//display students
			displayStudents(theStudents);
			
			//query for student lastName Cena
			theStudents=session.createQuery("from Student s where s.lastName='Cena'").getResultList();
			System.out.println("Students with last name of CENA");
			displayStudents(theStudents);
			System.out.println();
			//query for student lastName Cena or firstname under
			theStudents=session.createQuery("from Student s where "
					+ " s.lastName='Cena' OR s.firstName='under'").getResultList();
			System.out.println("Students with last name of CENA or firstname under");
			displayStudents(theStudents);
			System.out.println();
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student temp:theStudents) {
			System.out.println(temp);
		}
	}

}
