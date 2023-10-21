package com.luv2code.hibernate.demo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ordering.antlr.Factory;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	
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
		 
		 
		 //start a transcation
		 session.beginTransaction();
		 
		 //query students
		 List<Student> theStudents = session.createQuery("from Student").list();
		 
		 //display the students
		 displayStudents(theStudents);
		 
		 
		 //query students:lastname='saanu'
		 theStudents = session.createQuery("from Student s where s.lastName='saanu'").list();
		 
		 //display the students
		 System.out.println("\n\nStudents who have last name of saanu");
		 displayStudents(theStudents);
		 
		 //query students: lastName='saanu' OR firstName='paul'
		 theStudents = session.createQuery("from Student s where"
				 + "s.lastName='saanu' OR s.firstName='som'").list();
		 
		 System.out.println("\n\nStudents who have last name of saanu OR first name of som");
		 displayStudents(theStudents);
		 
		 //query students where email LIKE '%luv2code.com'
		 theStudents = session.createQuery("from Student s where"
				 + " s.email LIKE '%luv2code.com'").list();
		 
		 System.out.println("\n\nStudents whose email ends with luv2code.com");
		 displayStudents(theStudents);
				 
		 
		 //commit transcation
		 session.getTransaction().commit();
		 
		 System.out.println("done!...");
		 
	 }
	 finally {
		 factory.close();
	 }
}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			 System.out.println(tempStudent);
		 }
	} 
	 
}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
