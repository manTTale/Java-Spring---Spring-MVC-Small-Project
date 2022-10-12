package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		//CREATE SESSION
		Session session = factory.getCurrentSession();
		try {
			int studentId = 1;
			
			//start a transaction
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting student with id:" + studentId);
			Student myStudent = session.get(Student.class,studentId);
				

			//deleting the student
			//System.out.println("Deleting the student..."+myStudent);
			//session.delete(myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//deleting many entries
			System.out.println("Deleting the student with the id of 3");
			session.createQuery("delete from Student where id='3'").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
	}

}
