package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			//start a transaction
			session.beginTransaction();
			
			//get the instructor detail object
			int theId=3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
			//print the instructor detail
			System.out.println("instructor detail: "+instructorDetail);
			
			//print the associated instructor
			System.out.println("associated instructor: "+instructorDetail.getInstructor());
			
			//delete the instructor detail
			System.out.println("Deleting the instructor detail");
			
			//remove the associated object reference
			//break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
		
		
	}

}
