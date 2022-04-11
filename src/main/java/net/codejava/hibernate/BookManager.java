package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
		book.setTitle("Serlock Holmes");
		book.setAuthor("sir. A. C. Doyle");
		book.setPrice(40.00f);

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
	}

	protected void delete() {
		// code to remove a book
		// session.getTransaction().commit();
		// session.close();
	}

	public static void main(String[] args) {
		BookManager manager = new BookManager();
		manager.setup();

		manager.create();

		manager.exit();
	}
}
