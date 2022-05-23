package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.Scanner;

public class BookManager {
	protected SessionFactory sessionFactory;

	protected void setup() {
		// code to load Hibernate Session factory
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
		}

	}

	protected void exit() {
		// code to close Hibernate Session factory
		sessionFactory.close();
	}

	protected void create() {
		// code to save a book
		Book book = new Book();
		book.setTitle("Shining");
		book.setAuthor("Stephen King");
		book.setPrice(35.00f);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void read() {
		// code to get a book
	}

	protected void update() {
		// code to modify a book
		// session.getTransaction().commit();
		// session.close();
		// code to save a book
				Book book = new Book();
				book.setTitle("Shining");
				book.setAuthor("Stephen King");
				book.setPrice(35.00f);

				Session session = sessionFactory.openSession();
				session.beginTransaction();

				session.saveOrUpdate(book);

				session.getTransaction().commit();
				session.close();
	}

	protected void delete(long id) {
		// code to remove a book
		// session.getTransaction().commit();
		// session.close();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		    Book book ;
		    book = (Book)session.load(Book.class,id);
		    session.delete(book);

		    //This makes the pending delete to be done
		    

//			session.delete(book);

			session.getTransaction().commit();
			session.close();

		
	}

	public static void main(String[] args) {
		BookManager manager = new BookManager();
		

		System.out.println("Wybierz operację: 1. Dodanie pozycji, 2. Usunięcie pozycji");
		Scanner input = new Scanner(System.in);
		
		int number = input.nextInt();
		
		switch(number) {
		case 1:
			  manager.setup();
			  manager.create();
			  manager.exit();
		break;
		case 2:
			System.out.println("Podaj identyfijtor pozycji do usuniecia: ");
			Scanner in = new Scanner(System.in);
			String ide=in.next();
			long id = Long.parseLong(ide);
		  manager.setup();
		  manager.delete(id);
		  manager.exit();
		  break;
		}

	
	}
}
