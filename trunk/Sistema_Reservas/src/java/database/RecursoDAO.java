package database;

import entidades.Recurso;
import java.util.ArrayList;
import java.util.List;

public class RecursoDAO implements OperacoesDAO{

    @Override
    public boolean inserir(Object obj)
    {
        h.beginTransaction();
        {
            Recurso rec = new Recurso();
            rec = (Recurso) obj;
            h.saveOnly(rec);
        }
        h.endTransaction();
        return true;
    }

    @Override
    public ArrayList pesquisar()
    {
        h.beginTransaction();

             List<Recurso> l = h.list(Recurso.class);

        h.endTransaction();
        ArrayList<Recurso> recs = new ArrayList();
        recs.addAll(l);
        return recs;
    }

    @Override
    public boolean editar(Object obj)
    {
        h.beginTransaction();
        {
            //recinto q vem da interface jah editado
            Recurso rec = (Recurso) obj;
            //Recurso que vem do banco para ser editado
            Recurso rec1 = (Recurso) h.getObject(Recurso.class, rec.getIdRecurso());
            //o valor de r(atualizado) vai no valor do banco
            rec1 = rec;
            //atualiza o r1 que recebe os valores de r(atualizado)
            h.updateOnly(rec1);
        }
        h.endTransaction();
        return true;
    }

    @Override
    public boolean excluir(Object obj)
    {
        h.beginTransaction();
        {
            Recurso rec = (Recurso) obj;
            Recurso rec1 = (Recurso) h.getObject(Recurso.class, rec.getIdRecurso());
            h.delete(rec1);
        }
        h.endTransaction();
        return true;
    }

}
