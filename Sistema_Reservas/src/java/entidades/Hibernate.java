/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author 0213101
 */
public class Hibernate { //oi
    private Session session;
    private AnnotationConfiguration ac = new AnnotationConfiguration();

    private final SessionFactory sf = ac.configure().buildSessionFactory();

    /*
     * Abre a sessão do Hibernate para fazer as transações.
     */
    public void beginTransaction()
    {
        session = sf.getCurrentSession();
        session.beginTransaction();
        session.setFlushMode(FlushMode.COMMIT);     //consultas SQL serao executadas no momento do commit
    }

    /*
     * Encerra a sessão ao fim das transações.
     */
    public void endTransaction()
    {
        Transaction transaction = session.getTransaction();
        transaction.commit();
    }

    /*
     * Insere o objeto no banco de dados.
     */
    public void saveOnly(Object o)
    {
        session.saveOrUpdate(o);
    }

    //cuidado ao usar, para deletar eh necessario o getObject
    public void delete(Object o)
    {
        session.delete(o);
    }

    /*
     *retorna o objeto do banco de dados, o load puxa do banco tendo como parametro o id da linha
     *obrigatorio usar antes de updateOnly ou delete
     */
    public Object getObject(Class classObj, int id)
    {
        Object obj = session.load(classObj, id);
        return obj;
    }

    /*
     * Atualiza o campo baseado no  id do metodo getObject.
     */
    public void updateOnly(Object o)
    {
        session.update(o);
    }

    public List list(Class classObj)
    {
        Criteria cri = (Criteria) session.createCriteria(classObj);
        List<Object> l = cri.list();
        return l;
    }

}
