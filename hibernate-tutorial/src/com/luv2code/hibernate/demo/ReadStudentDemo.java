package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
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
		 Student tempStudent = new Student("Daff","walk","walk@luv2code.com");
		
		 
		 //start a transcation
		 session.beginTransaction();
		 
		 //save the student object
		 System.out.println("saving the student...");
		 System.out.println("tempStudent");
		 session.save(tempStudent);
		 
		 
		 //commit transcation
		 session.getTransaction().commit();
		 
		 //MY NEW CODE for retrvier/read data
		 
		 //find out the student's id:primary key
		 System.out.println("Saved student.Generated id: "+ tempStudent.getId());
		 
		 //now get a new session and start transcation
		 session = factory.getCurrentSession();
		 session.beginTransaction();
		 
		 //retrieve student based on the id:primary key
		 System.out.println("\nGetting student with id: " + tempStudent.getId());
		Student myStudent = session.get(Student.class, tempStudent.getId());		 
				 
		 System.out.println("Get complete: " + myStudent);
		 		
		 
		 //commit the transcation
		 
		 System.out.println("done!...");
		 
	 }
	 finally {
		 factory.close();
	 }
} 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
