package discoverita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import discoverita.jpa.Student;

public class App {

	public static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("discoverita");

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		App app = new App();
		app.saveStudent("Ivan");

	}

	public Student saveStudent(String studentName) {
		Student student = new Student();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {

			entityManager.getTransaction().begin();
			student.setStudentName(studentName);
			student = entityManager.merge(student);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return student;
	}

}
