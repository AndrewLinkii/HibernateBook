package code.dao.impl;

import code.dao.BookDao;
import code.model.Author;
import code.model.Book;
import code.model.Genre;
import code.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public void create(Book book) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public Book getBookByTitle(String title) {
        try(Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("from Book where title = :title");
            query.setParameter("title", title);
            return (Book) query.uniqueResult();
        } catch (Exception e) {
            throw new RuntimeException("cant get by title");
        }
    }

    @Override
    public List<Book> getBooksByAuthor(Author author) {
        try(Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("from Book where author = :a");
            query.setParameter("a", author);
            return query.list();

        } catch (Exception e) {
            throw new RuntimeException("cant get by author");
        }
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) {
        try(Session session = HibernateUtil.getFactory().openSession()) {
            Query query = session.createQuery("from Book where genre = :a");
            query.setParameter("a", genre);
            return query.list();

        } catch (Exception e) {
            throw new RuntimeException("cant get by genre");
        }
    }
}
