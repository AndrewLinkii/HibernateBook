package code.dao.impl;

import code.dao.GenreDao;
import code.model.Genre;
import code.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenreDaoImpl  implements GenreDao {
    @Override
    public void create(Genre genre) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getFactory().openSession();
            transaction = session.beginTransaction();
            session.save(genre);
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
