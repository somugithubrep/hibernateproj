package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {
	
	private static final SharedSessionContract factory = null;

	public static void main(String[] args) {
	
		
		//create session factory
		SessionFactory factory = new Configuration()
				                .configure("hibernate.cfg.xml")
				                .addAnnotatedClass(Student.class)
				                .buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();

	try {
		 //create a student object
		 System.out.println("creating new student object....");
		 Student tempStudent = new Student("paul","wall","paul@luv2code.com");
		 
		 //start a transcation
		 session.beginTransaction();
		 
		 //save the student object
		 System.out.println("saving the student...");
		 session.save(tempStudent);
		 
		 //commit transcation
		 session.getTransaction().commit();
		 
		 System.out.println("done!...");
		 
	 }
	 finally {
		 factory.close();
	 }
} 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
