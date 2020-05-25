package code.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory factory;

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("wrong configure ");
        }
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
