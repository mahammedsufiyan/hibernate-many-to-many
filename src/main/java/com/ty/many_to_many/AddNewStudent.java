package com.ty.many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddNewStudent {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction  = entityManager.getTransaction();
		
		Student student = new Student();
		student.setName("Nimra");
		student.setAge(20);
		
		Course course = entityManager.find(Course.class, 2);
		Course course2 = entityManager.find(Course.class, 3);
		
		List<Course> lists = new ArrayList<Course>();
		lists.add(course);
		lists.add(course2);
		student.setCourse(lists);
		entityTransaction.begin();
		entityManager.persist(student);
//		entityManager.persist(course); // ---> here i am not calling this method bcz... my table already has this coursses
//		entityManager.persist(course2); // ---> here i am not calling this method bcz... my table already has this coursses
		entityTransaction.commit();
	}
	
}
