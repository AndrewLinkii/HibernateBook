package code.dao.impl;

import code.dao.AuthorDao;
import code.model.Author;
import code.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public void create(Author author) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("cant add author");
        } finally {
            session.close();
        }
    }
}
