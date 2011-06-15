package database;

import entidades.Recinto;
import java.util.ArrayList;
import java.util.List;

public class RecintoDAO implements OperacoesDAO{

    @Override
    public boolean inserir(Object obj) {
        h.beginTransaction();
        {
            Recinto r = new Recinto();
            r = (Recinto) obj;
            h.saveOnly(r);
        }
        h.endTransaction();
        return true;
    }


    @Override
    public ArrayList pesquisar()
    {
        h.beginTransaction();
                   
            List<Recinto> l = h.list(Recinto.class);            
        
        h.endTransaction();
        ArrayList<Recinto> rs = new ArrayList();
        rs.addAll(l);
        return rs;
    }

    @Override
    public boolean editar(Object obj)
    {
        h.beginTransaction();
        {
            //recinto q vem da interface jah editado
            Recinto r = (Recinto) obj;
            //recinto que vem do banco para ser editado
            Recinto r1 = (Recinto) h.getObject(Recinto.class, r.getIdRecinto());
            //o valor de r(atualizado) vai no valor do banco
            r1 = r;
            //atualiza o r1 que recebe os valores de r(atualizado)
            h.updateOnly(r1);
        }
        h.endTransaction();
        return true;
    }

    @Override
    public boolean excluir(Object obj)
    {
        h.beginTransaction();
        {
            Recinto r = (Recinto) obj;
            Recinto r1 = (Recinto) h.getObject(Recinto.class, r.getIdRecinto());
            h.delete(r1);
        }
        h.endTransaction();
        return true;
    }

}
