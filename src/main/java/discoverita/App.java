package discoverita;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import discoverita.jpa.Student;
import discoverita.jpa.onetomany.Company;
import discoverita.jpa.onetomany.Employee;

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

		app.createCompany();

	}

	private void createCompany() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {

			entityManager.getTransaction().begin();

			Company company = new Company();
			company.setCity("Kolkata");
			company.setCountry("India");
			company.setState("Bengal");
			company.setStreet("Number 15");
			Employee employee1 = new Employee("Rockey");
			Employee employee2 = new Employee("Jose");
			Set<Employee> employees = new HashSet<Employee>();
			employees.add(employee1);
			employees.add(employee2);
			company.setEmployees(employees);
			entityManager.persist(company);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		} finally {
			entityManager.close();
		}

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
