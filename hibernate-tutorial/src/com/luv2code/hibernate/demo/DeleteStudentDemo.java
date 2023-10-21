package com.luv2code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {
	
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
		int studentId = 8;
		 
		 
		//now get a new session and start transcation
		 session = factory.getCurrentSession();
		 session.beginTransaction();
		 
		 //retrieve student based on the id:primary key
		 System.out.println("\nGetting student with id: " + studentId );
		Student myStudent = session.get(Student.class, studentId);
		
		//delete the student
		System.out.println("Deleting student: " + myStudent);
		session.delete(myStudent);		 
		 
		 		
		 
		 //commit the transcation
		 session.getTransaction().commit();
		 
		 
		 
		 
		System.out.println("done!...");
		 
	 }
	 finally {
		 factory.close();
	 }
} 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
