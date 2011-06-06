/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classes;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author 0213101
 */
public class Hibernate {
    private Session session;
    private AnnotationConfiguration ac = new AnnotationConfiguration();

    SessionFactory sf = ac.configure().buildSessionFactory();

    public void beginTransaction()
    {
        session = sf.getCurrentSession();
        session.beginTransaction();
        session.setFlushMode(FlushMode.COMMIT);     //consultas SQL serao executadas no momento do commit
    }

    public void endTransaction()
    {
        Transaction transaction = session.getTransaction();
        transaction.commit();
    }

    public void saveOrUpdate(Object o)
    {
        session.saveOrUpdate(o);
    }

    //cuidado ao usar
    public void delete(Object o)
    {
        session.delete(o);
    }

}
