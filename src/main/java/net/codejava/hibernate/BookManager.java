package net.codejava.hibernate;

import java.util.List;

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

	protected void create(String a, String t, float p) {
		// code to save a book
		Book book = new Book();
		book.setTitle(t);
		book.setAuthor(a);
		book.setPrice(p);

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(book);

		session.getTransaction().commit();
		session.close();
	}

	protected List<Book> read() {
		// code to get a book
		List<Book> book = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		book = session.createQuery("from Book").list();
		session.getTransaction().commit();
		//session.close();
		
		return book;
	}
	protected Book readByName(long id) {
		// code to get a book
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Book book = null;
		
		book = session.get(Book.class, id);
		session.getTransaction().commit();
		session.close();
		
		return book;
	}

	protected void update(String title, float p) {
		// code to modify a book
		// session.getTransaction().commit();
		// session.close();
		// code to save a book
				Book book = new Book();
				String t= book.getTitle();
				if(t==title)
				book.setPrice(p);

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

	
}
