package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
					Student student1 = new Student("John", "Cena", "cena@luv2code.com");
					Student student2 = new Student("Under", "Taker", "taker@luv2code.com");
					Student student3 = new Student("Nebunu", "Jupanu", "nebunu@luv2code.com");
					//start a transaction
					session.beginTransaction();
					//save the student object
					System.out.println("Saving the new Student object . . . ");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					//commit transaction
					session.getTransaction().commit();
					System.out.println("Done!");
					
				}
				finally {
					factory.close();
				}

	}

}
