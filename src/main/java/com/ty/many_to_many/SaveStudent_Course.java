package com.ty.many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveStudent_Course {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Student student = new Student();
		student.setName("Sahil");
		student.setAge(21);
		
		List<Course> list = new ArrayList<Course>();
		
		Course course =new Course();
		course.setName("java");
		course.setDuration(3);
		list.add(course);

		Course course2 =new Course();
		course2.setName("python");
		course2.setDuration(6);
		list.add(course2);
		

		Course course3 =new Course();
		course3.setName("java");
		course3.setDuration(3);
		list.add(course3);
		
		student.setCourse(list);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(course);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();
	}
}
