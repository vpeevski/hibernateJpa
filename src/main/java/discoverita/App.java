package discoverita;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import discoverita.jpa.Student;
import discoverita.jpa.granilarity.embedded.Address;
import discoverita.jpa.granilarity.embedded.User;
import discoverita.jpa.manytomany.unidirectional.Author;
import discoverita.jpa.manytomany.unidirectional.Book;
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

		app.createBooks();
		
		app.createUser();

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

	public void createBooks() {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			Set<Author> howToProgramWithJavaAuthor = new HashSet<Author>();
			Set<Author> howToProgramWithJava2ndAuthors = new HashSet<Author>();
			Set<Author> howToPlayGuitarAuthor = new HashSet<Author>();

			Author author = new Author();
			author.setAuthorName("Trevor Page");
			howToProgramWithJavaAuthor.add(author);

			Author author2 = new Author();
			author2.setAuthorName("John Doe");

			howToProgramWithJava2ndAuthors.add(author);
			howToProgramWithJava2ndAuthors.add(author2);
			howToPlayGuitarAuthor.add(author2);

			Book book = new Book();
			book.setBookName("How to Program with Java");

			Book book2 = new Book();
			book2.setBookName("How to Program with Java 2nd Edition");

			Book book3 = new Book();
			book3.setBookName("How to Play Guitar");

			book.setAuthors(howToProgramWithJavaAuthor);
			book2.setAuthors(howToProgramWithJava2ndAuthors);
			book3.setAuthors(howToPlayGuitarAuthor);

			entityManager.persist(book);
			entityManager.persist(book2);
			entityManager.persist(book3);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
	}
	
	public User createUser () {
		User user = new User();
		Address address = new Address();
		address.setCity("Sofia");
		address.setStreet("St. Kiprian");
		address.setZipcode("1799");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {

			entityManager.getTransaction().begin();
			user.setHomeAddress(address);
			entityManager.persist(user);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}
		return user;
	}

}
